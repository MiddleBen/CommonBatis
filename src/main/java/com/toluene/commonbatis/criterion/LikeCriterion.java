package com.toluene.commonbatis.criterion;

import com.toluene.commonbatis.exception.CommonBatisException;

/**
 * A criterion representing a "like" operation
 */
public class LikeCriterion implements Criterion {

    private static final long serialVersionUID = 1L;
    private final String propertyName;
    private final Object value;

    protected LikeCriterion(
            String propertyName, Object value) {
        this.propertyName = propertyName;
        this.value = value;
    }

    public String getStatement() throws CommonBatisException {
        return propertyName + " like ";
    }

    public String getPropertyName() {
        return propertyName;
    }

    public Object getValue() {
        return value;
    }

}
