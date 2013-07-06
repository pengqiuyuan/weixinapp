package com.weixin.app.orm;

import java.io.Serializable;
import java.util.Set;
import java.util.TreeSet;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;

/**
 * 简单查询基类
 */
public class SimpleQueryCondition implements Serializable {

    private static final long serialVersionUID = -5096309399465067054L;
    private Set<QueryColumnCondition> queryColumnCondition;
    private Set<Order> orderSet;
    DetachedCriteria criteria;
    @SuppressWarnings("rawtypes")
	Class clazz;

    protected <T> SimpleQueryCondition(Class<T> clazz) {
        this.clazz = clazz;
    }

    void addQueryCondition(QueryColumnCondition condition) {
        if (condition.getIndex() < 0) {
            condition.setIndex(queryColumnCondition.size() + 999999);
        }
        this.queryColumnCondition.add(condition);
    }

    /**
     * @return the queryColumnCondition
     */
    Set<QueryColumnCondition> getQueryColumnCondition() {
        return queryColumnCondition;
    }

    /**
     * @param queryColumnCondition the queryColumnCondition to set
     */
    void setQueryColumnCondition(
            Set<QueryColumnCondition> queryColumnCondition) {
        this.queryColumnCondition = queryColumnCondition;
    }

    public void setOrderItem(Set<Order> orderSet) {
        this.orderSet = orderSet;
    }

    void clean() {
        this.criteria = DetachedCriteria.forClass(clazz);
        this.queryColumnCondition = new TreeSet<QueryColumnCondition>();
        if (orderSet != null) {
            for (Order order : orderSet) {
                this.criteria.addOrder(order);
            }
        }
    }

    public Set<Order> getOrderSet() {
        return orderSet;
    }

    public void setOrderSet(Set<Order> orderSet) {
        this.orderSet = orderSet;
    }
}
