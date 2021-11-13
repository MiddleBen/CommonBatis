package com.toluene.commonbatis.dao.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.toluene.commonbatis.OrCriteria;

public interface CommonDaoMapper {

    <T> List<T> selectByCriteria(Class<T> clazz, @Param("orCriteria") OrCriteria orCriteria);

    <K, T extends K> List<T> selectByPrimaryKey(Class<T> clazz, @Param("key") K key);

    <T> int countByCriteria(Class<T> clazz, @Param("orCriteria") OrCriteria orCriteria);

    <K, T extends K> int deleteByPrimaryKey(Class<T> clazz, @Param("key") K key);

    <T> int deleteByCriteria(Class<T> clazz, @Param("orCriteria") OrCriteria orCriteria);

    <T> int insert(@Param("entity") T t);

    <T> int updateByCriteria(@Param("entity") T t, @Param("orCriteria") OrCriteria orCriteria);

    <K, T extends K> int updateByPrimaryKey(@Param("entity") T t, @Param("key") K key);
}
