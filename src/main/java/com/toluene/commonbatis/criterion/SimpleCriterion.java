package com.toluene.commonbatis.criterion;

import com.toluene.commonbatis.exception.CommonBatisException;

public class SimpleCriterion implements Criterion {

    private static final long serialVersionUID = 1L;
    private final String propertyName;
    private final Object value;
    private final String op;

    protected SimpleCriterion(String propertyName, Object value, String op) {
        this.propertyName = propertyName;
        this.value = value;
        this.op = op;
    }

    public String getStatement() throws CommonBatisException {
        return propertyName + " " + op + " ";
    }

    public String toString() {
        return propertyName + getOp() + value;
    }

    protected final String getOp() {
        return op;
    }

    public String getPropertyName() {
        return propertyName;
    }

    public Object getValue() {
        return value;
    }

}
