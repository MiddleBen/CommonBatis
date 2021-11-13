package com.toluene.commonbatis.util;

import java.util.Collections;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class SimpleCache {

    public static enum MAPTYPE {
        SELECT(0), COUNT(1), UPDATE(2), INSERT(3), DEL(4);
        private int index;

        MAPTYPE(int index) {
            this.index = index;
        }

        public int getIndex() {
            return this.index;
        }
    }

    private static final Map<String, String> selectPrefixSqlMap = new ConcurrentHashMap<String, String>();
    private static final Map<String, String> countPrefixSqlMap = new ConcurrentHashMap<String, String>();
    private static final Map<String, String> updatePrefixSqlMap = new ConcurrentHashMap<String, String>();
    private static final Map<String, String> insertPrefixSqlMap = new ConcurrentHashMap<String, String>();
    private static final Map<String, String> delPrefixSqlMap = new ConcurrentHashMap<String, String>();

    public static void put(String key, String value, MAPTYPE maptype) {
        int index = maptype.getIndex();
        switch (index) {
            case 0:
                synchronized (selectPrefixSqlMap) {
                    selectPrefixSqlMap.put(key, value);
                }
                break;
            case 1:
                synchronized (countPrefixSqlMap) {
                    countPrefixSqlMap.put(key, value);
                }
                break;
            case 2:
                synchronized (updatePrefixSqlMap) {
                    updatePrefixSqlMap.put(key, value);
                }
                break;
            case 3:
                synchronized (insertPrefixSqlMap) {
                    insertPrefixSqlMap.put(key, value);
                }
                break;
            case 4:
                synchronized (delPrefixSqlMap) {
                    delPrefixSqlMap.put(key, value);
                }
                break;
            default:
                throw new RuntimeException("put value into simpleCache false!");
        }
    }

    public static String get(String key, MAPTYPE maptype) {
        int index = maptype.getIndex();
        switch (index) {
            case 0:
                return selectPrefixSqlMap.get(key);
            case 1:
                return countPrefixSqlMap.get(key);
            case 2:
                return updatePrefixSqlMap.get(key);
            case 3:
                return insertPrefixSqlMap.get(key);
            case 4:
                return delPrefixSqlMap.get(key);
            default:
                throw new RuntimeException("get value from simpleCache false!");
        }
    }

    public static Map<String, String> getCountPrefixSqlMap() {
        return Collections.unmodifiableMap(countPrefixSqlMap);
    }

    public static Map<String, String> getSelectPrefixSqlMap() {
        return Collections.unmodifiableMap(selectPrefixSqlMap);
    }

    public static Map<String, String> getUpdatePrefixSqlMap() {
        return Collections.unmodifiableMap(updatePrefixSqlMap);
    }

    public static Map<String, String> getAddPrefixSqlMap() {
        return Collections.unmodifiableMap(insertPrefixSqlMap);
    }

    public static Map<String, String> getDelPrefixSqlMap() {
        return Collections.unmodifiableMap(delPrefixSqlMap);
    }

}

