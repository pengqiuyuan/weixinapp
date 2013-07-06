package com.weixin.app.orm;

import java.util.Collection;

import org.hibernate.criterion.Restrictions;

/**
 * 转化标注操作符为Hibernate DetachedCriteria 操作
 * @author AsOne
 *
 */
public class SimpleQueryOperator {

    protected static boolean prepare(SimpleQueryCondition condition,
            QueryColumnCondition column) {
        Object param = column.getValue();
        if (param == null) {
            if (column.isAbsenceWhenNull() == false) {
                condition.criteria.add(Restrictions.isNull(column.getPersistenProperty()));
            }
            return false;
        }
        if (column.getConvert() != null) {
            param = column.getConvert().convert(param);
            column.setValue(param);
        }
        return true;
    }

    public static void operator(SimpleQueryCondition condition,
            QueryColumnCondition column) {
        if (prepare(condition, column) == false) {
            return;
        }
        switch (column.getOperator()) {
            case EQ:
            	if("".equals(column.getSubMapping())){
            		condition.criteria.add(Restrictions.eq(column.getPersistenProperty(), column.getValue()));
            	}else{
            		condition.criteria.createAlias(column.getSubMapping(), column.getSubMapping()).add(Restrictions.eq(column.getPersistenProperty(), column.getValue()));
            	}
                break;
            case LT:
            	if("".equals(column.getSubMapping())){
            		condition.criteria.add(Restrictions.lt(column.getPersistenProperty(), column.getValue()));
            	}else{
            		condition.criteria.createAlias(column.getSubMapping(), column.getSubMapping()).add(Restrictions.lt(column.getPersistenProperty(), column.getValue()));
            	}
                break;
            case LE:
            	if("".equals(column.getSubMapping())){
            		condition.criteria.add(Restrictions.le(column.getPersistenProperty(), column.getValue()));
            	}else{
            		condition.criteria.createAlias(column.getSubMapping(), column.getSubMapping()).add(Restrictions.le(column.getPersistenProperty(), column.getValue()));
            	}
                break;
            case GE:
            	if("".equals(column.getSubMapping())){
            		condition.criteria.add(Restrictions.ge(column.getPersistenProperty(), column.getValue()));
            	}else{
            		condition.criteria.createAlias(column.getSubMapping(), column.getSubMapping()).add(Restrictions.ge(column.getPersistenProperty(), column.getValue()));
            	}
                break;
            case GT:
            	if("".equals(column.getSubMapping())){
            		condition.criteria.add(Restrictions.gt(column.getPersistenProperty(), column.getValue()));
            	}else{
            		condition.criteria.createAlias(column.getSubMapping(), column.getSubMapping()).add(Restrictions.gt(column.getPersistenProperty(), column.getValue()));
            	}
                break;
            case NULL:
            	if("".equals(column.getSubMapping())){
            		condition.criteria.add(Restrictions.isNull(column.getPersistenProperty()));
            	}else{
            		condition.criteria.createAlias(column.getSubMapping(), column.getSubMapping()).add(Restrictions.isNull(column.getPersistenProperty()));
            	}
            	break;
            case NOTNULL:
            	if("".equals(column.getSubMapping())){
            		condition.criteria.add(Restrictions.isNotNull(column.getPersistenProperty()));
            	}else{
            		condition.criteria.createAlias(column.getSubMapping(), column.getSubMapping()).add(Restrictions.isNotNull(column.getPersistenProperty()));
            	}
            	break;
            case IN:
                Object param = column.getValue();
                if (param instanceof Object[]) {
                	if("".equals(column.getSubMapping())){
                		condition.criteria.add(Restrictions.in(column.getPersistenProperty(), (Object[]) param));
                	}else{
                		condition.criteria.createAlias(column.getSubMapping(), column.getSubMapping()).add(Restrictions.in(column.getPersistenProperty(), (Object[]) param));
                	}
                    return;
                }
                if (param instanceof Collection) {
                	if("".equals(column.getSubMapping())){
                		condition.criteria.add(Restrictions.in(column.getPersistenProperty(), ((Collection) param)));
                	}else{
                		condition.criteria.createAlias(column.getSubMapping(), column.getSubMapping()).add(Restrictions.in(column.getPersistenProperty(), ((Collection) param)));
                	}
                    return;
                }
                break;
            case LIKE:
            	if("".equals(column.getSubMapping())){
            		condition.criteria.add(Restrictions.like(column.getPersistenProperty(), "%"+column.getValue()+"%"));
            	}else{
            		condition.criteria.createAlias(column.getSubMapping(), column.getSubMapping()).add(Restrictions.like(column.getPersistenProperty(), "%"+column.getValue()+"%"));
            	}
                break;
            default:
                throw new RuntimeException("not support operator [" + column.getOperator() + "]");
        }
    }
}
