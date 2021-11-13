package com.toluene.commonbatis.criterion;

import com.toluene.commonbatis.exception.CommonBatisException;

/**
 * a criterion representing the specify property should be in the values
 */
public class InCriterion implements Criterion {

    private static final long serialVersionUID = 1L;
    private final String propertyName;
    @SuppressWarnings("unused")
    private final Object[] values;

    protected InCriterion(String propertyName, Object[] values) {
        this.propertyName = propertyName;
        this.values = values;
    }

    public String getStatement() throws CommonBatisException {
        return propertyName + " in ";
    }

}
