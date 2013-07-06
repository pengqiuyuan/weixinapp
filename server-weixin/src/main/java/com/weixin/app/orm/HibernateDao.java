package com.weixin.app.orm;

import java.io.Serializable;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.StringTokenizer;

import org.hibernate.Criteria;
import org.hibernate.Hibernate;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.CriteriaSpecification;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.hibernate.metadata.ClassMetadata;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.orm.hibernate3.SessionFactoryUtils;

import org.springframework.orm.hibernate3.HibernateCallback;

import com.weixin.app.orm.annotation.SimpleQueryOrderItemAsc;
import com.weixin.app.orm.annotation.SimpleQueryOrderItemDesc;
import com.weixin.app.orm.annotation.SimpleQueryProperty;

public class HibernateDao<T, PK extends Serializable> {

    protected static Logger logger = LoggerFactory.getLogger(HibernateDao.class);
    private HibernateTemplate hibernateTemplate;
    protected Class<T> entityClass;

    public HibernateDao() {
        this.entityClass = (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
    }

    public HibernateTemplate getHibernateTemplate() {
        return hibernateTemplate;
    }

    @Autowired
    public void setHibernateTemplate(HibernateTemplate value) {
        hibernateTemplate = value;
    }

    /**
     * 保存新增或修改的对象.
     */
    public void save(final T entity) {
        Assert.notNull(entity, "entity不能为空");

        this.hibernateTemplate.saveOrUpdate(entity);
    }

    public void update(final T entity) {
        Assert.notNull(entity, "entity不能为空");
        this.getHibernateTemplate().evict(entity);
        this.getHibernateTemplate().flush();
        this.getHibernateTemplate().clear();
        this.hibernateTemplate.update(entity);
    }

    public void merge(final T entity) {
        Assert.notNull(entity, "entity不能为空");
        this.hibernateTemplate.merge(entity);
    }

    /**
     * 删除对象.
     *
     * @param entity 对象必须是session中的对象或含id属性的transient对象.
     */
    public void delete(final T entity) {
        Assert.notNull(entity, "entity不能为空");
        this.hibernateTemplate.delete(entity);
    }

    /**
     * 按id删除对象.
     */
    public void delete(final PK id) {
        Assert.notNull(id, "id不能为空");
        delete(get(id));
    }

    /**
     * 按id获取对象.
     */
    public T get(final PK id) {
        Assert.notNull(id, "id不能为空");
        return (T) this.hibernateTemplate.get(entityClass, id);
    }

    /**
     * 按id列表获取对象列表.
     */
    public List<T> get(final Collection<PK> ids) {
        return find(Restrictions.in(getIdName(), ids));
    }

    /**
     *	获取全部对象.
     */
    public List<T> getAll() {
        return find();
    }

    /**
     *	获取全部对象, 支持按属性行序.
     */
    public List<T> getAll(String orderByProperty, boolean isAsc) {
        Criteria c = createCriteria();
        if (isAsc) {
            c.addOrder(Order.asc(orderByProperty));
        } else {
            c.addOrder(Order.desc(orderByProperty));
        }
        return c.list();
    }

    /**
     * 按属性查找对象列表, 匹配方式为相等.
     */
    public List<T> findBy(final String propertyName, final Object value) {
        Assert.hasText(propertyName, "propertyName不能为空");
        Criterion criterion = Restrictions.eq(propertyName, value);
        return find(criterion);
    }

    /**
     * 按属性查找唯一对象, 匹配方式为相等.
     */
    public T findUniqueBy(final String propertyName, final Object value) {
        Assert.hasText(propertyName, "propertyName不能为空");
        Criterion criterion = Restrictions.eq(propertyName, value);
        return (T) createCriteria(criterion).uniqueResult();
    }

    /**
     * 按HQL查询对象列表.
     *
     * @param values 数量可变的参数,按顺序绑定.
     */
    public <X> List<X> find(final String hql, final Object... values) {
        return createQuery(hql, values).list();
    }

    /**
     * 按HQL查询对象列表.分页
     * @param <X>
     * @param hql
     * @param first
     * @param max
     * @param values
     * @return
     */
    public <X> List<X> find(final String hql, Integer first, Integer max, final Object... values) {
        return createQuery(hql, values).setFirstResult(first).setMaxResults(max).list();
    }

    /**
     * 按HQL统计
     * @param hql
     * @param values
     * @return
     */
    public long findLong(final String hql, final Object... values) {
        return (Long) createQuery(hql, values).uniqueResult();
    }

    /**
     * 按HQL查询对象列表.
     *
     * @param values 命名参数,按名称绑定.
     */
    public <X> List<X> find(final String hql, final Map<String, ?> values) {
        return createQuery(hql, values).list();
    }

    /**
     * 按HQL查询唯一对象.
     *
     * @param values 数量可变的参数,按顺序绑定.
     */
    public <X> X findUnique(final String hql, final Object... values) {
        return (X) createQuery(hql, values).uniqueResult();
    }

    /**
     * 按HQL查询唯一对象.
     *
     * @param values 命名参数,按名称绑定.
     */
    public <X> X findUnique(final String hql, final Map<String, ?> values) {
        return (X) createQuery(hql, values).uniqueResult();
    }

    /**
     * 执行HQL进行批量修改/删除操作.
     *
     * @param values 数量可变的参数,按顺序绑定.
     * @return 更新记录数.
     */
    public int batchExecute(final String hql, final Object... values) {
        return createQuery(hql, values).executeUpdate();
    }

    /**
     * 执行HQL进行批量修改/删除操作.
     *
     * @param values 命名参数,按名称绑定.
     * @return 更新记录数.
     */
    public int batchExecute(final String hql, final Map<String, ?> values) {
        return createQuery(hql, values).executeUpdate();
    }

    /**
     * 根据查询HQL与参数列表创建Query对象.
     * 与find()函数可进行更加灵活的操作.
     *
     * @param values 数量可变的参数,按顺序绑定.
     */
    public Query createQuery(final String queryString, final Object... values) {
        Assert.hasText(queryString, "queryString不能为空");


        //Query query = this.hibernateTemplate.getSessionFactory().openSession().createQuery(queryString);
        Query query = this.hibernateTemplate.getSessionFactory().getCurrentSession().createQuery(queryString);


        if (values != null) {
            for (int i = 0; i < values.length; i++) {
                query.setParameter(i, values[i]);
            }
        }
        return query;
    }

    /**
     * 根据查询HQL与参数列表创建Query对象.
     * 与find()函数可进行更加灵活的操作.
     *
     * @param values 命名参数,按名称绑定.
     */
    public Query createQuery(final String queryString, final Map<String, ?> values) {
        Assert.hasText(queryString, "queryString不能为空");
        Query query = this.hibernateTemplate.getSessionFactory().getCurrentSession().createQuery(queryString);
        if (values != null) {
            query.setProperties(values);
        }
        return query;
    }

    /**
     * 按Criteria查询对象列表.
     *
     * @param criterions 数量可变的Criterion.
     */
    public List<T> find(final Criterion... criterions) {
        return createCriteria(criterions).list();
    }
    
    public List<T> find(int first, int max, final Criterion... criterions){
    	Criteria criteria = createCriteria(criterions);
    	criteria.setFirstResult(first);
    	criteria.setMaxResults(max);
    	return criteria.list();
    }
    
    public List<T> find(int first, int max, Order order, final Criterion... criterions){
    	Criteria criteria = createCriteria(criterions);
    	if (order != null) {
            criteria.addOrder(order);
        }
    	criteria.setFirstResult(first);
    	criteria.setMaxResults(max);
    	return criteria.list();
    }

    /**
     * 按Criteria查询唯一对象.
     *
     * @param criterions 数量可变的Criterion.
     */
    public T findUnique(final Criterion... criterions) {
        return (T) createCriteria(criterions).uniqueResult();
    }

    /**
     * 根据Criterion条件创建Criteria.
     * 与find()函数可进行更加灵活的操作.
     *
     * @param criterions 数量可变的Criterion.
     */
    public Criteria createCriteria(final Criterion... criterions) {
        Criteria criteria = this.hibernateTemplate.getSessionFactory().getCurrentSession().createCriteria(entityClass);
        for (Criterion c : criterions) {
            criteria.add(c);
        }
        return criteria;
    }

    /**
     * 初始化对象.
     * 使用load()方法得到的仅是对象Proxy, 在传到View层前需要进行初始化.
     * 如果传入entity, 则只初始化entity的直接属性,但不会初始化延迟加载的关联集合和属性.
     * 如需初始化关联属性,需执行:
     * Hibernate.initialize(user.getRoles())，初始化User的直接属性和关联集合.
     * Hibernate.initialize(user.getDescription())，初始化User的直接属性和延迟加载的Description属性.
     */
    public void initProxyObject(Object proxy) {
        Hibernate.initialize(proxy);
    }

    /**
     * Flush当前Session.
     */
    public void flush() {
        this.hibernateTemplate.getSessionFactory().getCurrentSession().flush();
    }

    /**
     * 为Query添加distinct transformer.
     * 预加载关联对象的HQL会引起主对象重复, 需要进行distinct处理.
     */
    public Query distinct(Query query) {
        query.setResultTransformer(CriteriaSpecification.DISTINCT_ROOT_ENTITY);
        return query;
    }

    /**
     * 为Criteria添加distinct transformer.
     * 预加载关联对象的HQL会引起主对象重复, 需要进行distinct处理.
     */
    public Criteria distinct(Criteria criteria) {
        criteria.setResultTransformer(CriteriaSpecification.DISTINCT_ROOT_ENTITY);
        return criteria;
    }

    /**
     * 取得对象的主键名.
     */
    public String getIdName() {
        ClassMetadata meta = this.hibernateTemplate.getSessionFactory().getClassMetadata(entityClass);
        return meta.getIdentifierPropertyName();
    }

    /**
     * 判断对象的属性值在数据库内是否唯一.
     *
     * 在修改对象的情景下,如果属性新修改的值(value)等于属性原来的值(orgValue)则不作比较.
     */
    public boolean isPropertyUnique(final String propertyName, final Object newValue, final Object oldValue) {
        if (newValue == null || newValue.equals(oldValue)) {
            return true;
        }
        Object object = findUniqueBy(propertyName, newValue);
        return (object == null);
    }

    public List<T> findByCriteria(Criterion... criterion) {
        Criteria criteria = createCriteria(criterion);
        criteria.setProjection(null);
        criteria.setResultTransformer(Criteria.ROOT_ENTITY);
        return criteria.list();
    }

    /**
     * 带排序条件,约束条件获取结果集合
     * 
     * @param order
     *            设置排序条件
     * @param criterion
     *            约束条件
     * @return 结果集合List<T>
     */
    public List<T> findByCriteria(Order order, Criterion... criterion) {
        Criteria criteria = createCriteria(criterion);
        if (order != null) {
            criteria.addOrder(order);
        }
        criteria.setProjection(null);
        criteria.setResultTransformer(Criteria.ROOT_ENTITY);
        return criteria.list();
    }

    /*Simple Query Condition*/
    public final List<T> excuteSimpleQuery(SimpleQueryCondition condition) {
        DetachedCriteria criteria = genSimpleQueryCondition(condition);
        criteria.setProjection(null);
        criteria.setResultTransformer(Criteria.ROOT_ENTITY);
        return this.hibernateTemplate.findByCriteria(criteria);
    }

    public final Page<T> excuteSimpleQuery(SimpleQueryCondition condition, final PageRequest pageRequest) {
        DetachedCriteria criteria = genSimpleQueryCondition(condition);

        
        Page<T> page = new Page<T>(pageRequest);
        if (pageRequest.isCountTotal()) {
            long totalCount = countSimpleQueryResult(criteria);
            page.setTotalItems(totalCount);
        }

        criteria.setProjection(null);
        criteria.setResultTransformer(Criteria.ROOT_ENTITY);

        List result = this.hibernateTemplate.findByCriteria(criteria, pageRequest.getOffset(),
                pageRequest.getPageSize());
        page.setResult(result);
        return page;
    }
    
    public long countSimpleQuery(SimpleQueryCondition cond){
		return this.countByCriteria(genSimpleQueryCondition(cond));
	}
    private Long countSimpleQueryResult(final DetachedCriteria detachedCriteria) {
        Long count = (Long) getHibernateTemplate().execute(
                new HibernateCallback() {

                    public Object doInHibernate(Session session)
                            throws HibernateException {
                        Criteria criteria = detachedCriteria.getExecutableCriteria(session);
                        return criteria.setProjection(Projections.rowCount()).uniqueResult();
                    }
                });
        return count;
    }

    public final DetachedCriteria genSimpleQueryCondition(
            SimpleQueryCondition condition) {
        condition.clean();
        Set<QueryColumnCondition> set = null;
        populate(condition);
        set = condition.getQueryColumnCondition();
        for (java.util.Iterator<QueryColumnCondition> it = set.iterator(); it.hasNext();) {
            QueryColumnCondition column = it.next();
            SimpleQueryOperator.operator(condition, column);
        }

        SimpleQueryOrderItemAsc orderItemAsc = (SimpleQueryOrderItemAsc) condition.getClass().getAnnotation(SimpleQueryOrderItemAsc.class);

        SimpleQueryOrderItemDesc orderItemDesc = (SimpleQueryOrderItemDesc) condition.getClass().getAnnotation(SimpleQueryOrderItemDesc.class);

        if (orderItemAsc != null) {
            setOrderItem(orderItemAsc.propertyName(), false, condition);
        }
        if (orderItemDesc != null) {
            setOrderItem(orderItemDesc.propertyName(), true, condition);
        }
        return condition.criteria;
    }

    private void populate(SimpleQueryCondition condition) {
        Method[] methods = condition.getClass().getMethods();
        for (int i = 0; i < methods.length; i++) {
            Method method = methods[i];
            if (method.getReturnType() == null) {
                continue;
            }
            process(condition, method);
        }
    }

    private void setOrderItem(String propertyName, boolean desc,
            SimpleQueryCondition condition) {
        if (propertyName.trim().equals("") == false) {
            StringTokenizer st = new StringTokenizer(propertyName, ",");
            while (st.hasMoreElements()) {
                String name = (String) st.nextElement();
                Order order = null;
                if (desc) {
                    order = Order.desc(name.trim());
                } else {
                    order = Order.asc(name.trim());
                }
                condition.criteria.addOrder(order);
            }
        }
    }

    private void process(SimpleQueryCondition condition, Method method) {
        SimpleQueryProperty property = method.getAnnotation(SimpleQueryProperty.class);
        
        if (property == null) {
            return;
        }

        QueryColumnCondition cond = new QueryColumnCondition();
        cond.setAbsenceWhenNull(property.absenceWhenNull());
        if (property.convertClass() != null
                && property.convertClass().trim().equals("") == false) {
            try {
                cond.setConvert((ConditionPropertyConvertor) Class.forName(
                        property.convertClass()).newInstance());
            } catch (Throwable e) {
                logger.error("", e);
                throw new RuntimeException(e);
            }
        }

       // cond.setOperator(property.operator());
        cond.setPersistenProperty(property.property());
        cond.setIndex(property.index());
        cond.setSubMapping(property.subMapping());
        try {
            Object value = method.invoke(condition);
            cond.setValue(value);
        } catch (Throwable e) {
            logger.error("", e);
            throw new RuntimeException(e);
        }

        condition.addQueryCondition(cond);
    }
    

    @SuppressWarnings("unchecked")
    public Long countByCriteria(final DetachedCriteria detachedCriteria) {
        
		Long count = (Long) getHibernateTemplate().execute(
                new HibernateCallback() {
                    public Object doInHibernate(Session session)
                            throws HibernateException {
                        Criteria criteria = detachedCriteria.getExecutableCriteria(session);
                        return criteria.setProjection(Projections.rowCount()).uniqueResult();
                    }
                });
        return count;
    }
    public Object executeSQL(final String sql,final Object... values){
    	return getHibernateTemplate().execute(new HibernateCallback<Object>(){

			@Override
			public Object doInHibernate(
					final org.hibernate.Session session)
					throws HibernateException, SQLException {
				Connection connection = SessionFactoryUtils.getDataSource(session.getSessionFactory()).getConnection();
				PreparedStatement statement = 
						connection.prepareStatement(sql);
				if(values!=null){
					for(int i=0;i<values.length;i++){
						statement.setObject(i+1, values[i]);

					}
				}
				logger.debug("native sql: "+sql);
			return statement.executeUpdate();
			}
        });
    }  
}
