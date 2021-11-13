package com.toluene.commonbatis.criterion;

import com.toluene.commonbatis.exception.CommonBatisException;

/**
 * Constrains a property should not be null;
 */
public class NotNullCriterion implements Criterion {

    private static final long serialVersionUID = 1L;
    private final String propertyName;

    protected NotNullCriterion(String propertyName) {
        this.propertyName = propertyName;
    }

    public String toString() {
        return propertyName + " is not null";
    }

    public String getStatement() throws CommonBatisException {
        return propertyName + "is not null";
    }

}
