package com.toluene.commonbatis.criterion;

import java.util.Collection;

/**
 * this class is used to build criterion. just as a criterion's factory
 */
public class Restrictions {

    private Restrictions() {
        // cannot be instantiated
    }

    /**
     * create a SimpleCriterion represent an equal operation
     *
     * @param propertyName
     * @param value
     * @return Criterion
     */
    public static SimpleCriterion eq(String propertyName, Object value) {
        return new SimpleCriterion(propertyName, value, "=");
    }

    /**
     * create a SimpleCriterion represent an not equal operation
     *
     * @param propertyName
     * @param value
     * @return Criterion
     */
    public static SimpleCriterion ne(String propertyName, Object value) {
        return new SimpleCriterion(propertyName, value, "!=");
    }

    /**
     * create a SimpleCriterion represent an greater than operation
     *
     * @param propertyName
     * @param value
     * @return Criterion
     */
    public static SimpleCriterion gt(String propertyName, Object value) {
        return new SimpleCriterion(propertyName, value, ">");
    }

    /**
     * create a SimpleCriterion represent an less than operation
     *
     * @param propertyName
     * @param value
     * @return Criterion
     */
    public static SimpleCriterion lt(String propertyName, Object value) {
        return new SimpleCriterion(propertyName, value, "<");
    }

    /**
     * create a SimpleCriterion represent an less than or equal operation
     *
     * @param propertyName
     * @param value
     * @return Criterion
     */
    public static SimpleCriterion le(String propertyName, Object value) {
        return new SimpleCriterion(propertyName, value, "<=");
    }

    /**
     * create a SimpleCriterion represent an greater than or equal operation
     *
     * @param propertyName
     * @param value
     * @return Criterion
     */
    public static SimpleCriterion ge(String propertyName, Object value) {
        return new SimpleCriterion(propertyName, value, ">=");
    }

    /**
     * create a LikeCriterion represent an "like" operation
     *
     * @param propertyName
     * @param value
     * @return Criterion
     */
    public static LikeCriterion like(String propertyName, Object value) {
        return new LikeCriterion(propertyName, value);
    }

    /**
     * create a BetweenCriterion represent an "like" operation
     *
     * @param propertyName
     * @param lo           value
     * @param hi           value
     * @return Criterion
     */
    public static BetweenCriterion between(String propertyName, Object lo,
                                           Object hi) {
        return new BetweenCriterion(propertyName, lo, hi);
    }

    /**
     * create a InCriterion represent an "in" operation
     *
     * @param propertyName
     * @param values
     * @return Criterion
     */
    public static InCriterion in(String propertyName, Object[] values) {
        return new InCriterion(propertyName, values);
    }

    /**
     * create a InCriterion represent an "in" operation
     *
     * @param propertyName
     * @param values
     * @return Criterion
     */
    public static InCriterion in(String propertyName, Collection<?> values) {
        return new InCriterion(propertyName, values.toArray());
    }

    /**
     * create a InCriterion represent an "property is null" operation
     *
     * @return Criterion
     */
    public static NullCriterion isNull(String propertyName) {
        return new NullCriterion(propertyName);
    }

    /**
     * create a NotNullCriterion represent an "property is not null" operation
     *
     * @return Criterion
     */
    public static NotNullCriterion isNotNull(String propertyName) {
        return new NotNullCriterion(propertyName);
    }

}
