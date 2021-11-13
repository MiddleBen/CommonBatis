package com.toluene.commonbatis.criterion;

import java.io.Serializable;

import com.toluene.commonbatis.exception.CommonBatisException;

/**
 * a interface should be implemented to represent a constraint in a criteria
 * <p/>
 * *
 */
public interface Criterion extends Serializable {

    /**
     * Render the SQL fragment
     *
     * @throws com.toluene.commonbatis.exception.CommonBatisException Problem during rendering.
     */
    public String getStatement() throws CommonBatisException;

}