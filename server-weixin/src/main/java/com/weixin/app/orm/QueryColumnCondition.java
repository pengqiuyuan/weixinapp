package com.weixin.app.orm;


import java.io.Serializable;

import com.weixin.app.orm.annotation.OperatorType;

class QueryColumnCondition implements Serializable, Comparable<QueryColumnCondition> {

    /**
     * 查询条件字段 版本1.0
     */
    private static final long serialVersionUID = 1L;
    /**
     * 持久化对象属性名称
     */
    private String persistenProperty;
    /**
     * 值为空时HQL语名是否包含isNull子句
     */
    private boolean absenceWhenNull = true;
    /**
     * 操作对象
     */
    private OperatorType operator;
    /**
     * 对象转换器
     */
    private ConditionPropertyConvertor convert;
    /**
     * 值对象
     */
    private Object value;
    /**
     * 序列
     */
    private int index;
    
    private String subMapping;

    public QueryColumnCondition() {
        this.index = this.hashCode();
    }

    /**
     * @return the index
     */
    public int getIndex() {
        return index;
    }

    /**
     * @param index the index to set
     */
    public void setIndex(int index) {
        this.index = index;
    }

    /**
     * @return the value
     */
    public Object getValue() {
        return value;
    }

    /**
     * @param value the value to set
     */
    public void setValue(Object value) {
        this.value = value;
    }

    /**
     * @return the convert
     */
    public ConditionPropertyConvertor getConvert() {
        return convert;
    }

    /**
     * @param convert the convert to set
     */
    public void setConvert(ConditionPropertyConvertor convert) {
        this.convert = convert;
    }

    /**
     * @return the persistenProperty
     */
    public String getPersistenProperty() {
        return persistenProperty;
    }

    /**
     * @param persistenProperty the persistenProperty to set
     */
    public void setPersistenProperty(String persistenProperty) {
        this.persistenProperty = persistenProperty;
    }

    /**
     * @return the absenceWhenNull
     */
    public boolean isAbsenceWhenNull() {
        return absenceWhenNull;
    }

    /**
     * @param absenceWhenNull the absenceWhenNull to set
     */
    public void setAbsenceWhenNull(boolean absenceWhenNull) {
        this.absenceWhenNull = absenceWhenNull;
    }

    /**
     * @return the operator
     */
    public OperatorType getOperator() {
        return operator;
    }

    /**
     * @param operator the operator to set
     */
    public void setOperator(OperatorType operator) {
        this.operator = operator;
    }

    public int compareTo(QueryColumnCondition o) {
        return index - o.index;
    }

	public String getSubMapping() {
		return subMapping;
	}

	public void setSubMapping(String subMapping) {
		this.subMapping = subMapping;
	}
    
}