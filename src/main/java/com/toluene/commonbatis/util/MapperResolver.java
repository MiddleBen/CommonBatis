package com.toluene.commonbatis.util;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.springframework.core.io.ClassPathResource;
import org.xml.sax.SAXException;

import java.io.IOException;
import java.util.*;

public class MapperResolver {

    private static Map<String, SimpleCache.MAPTYPE> sqlIdToCacheMap = new HashMap<String, SimpleCache.MAPTYPE>();
    private static Map<SimpleCache.MAPTYPE, String> MapTypeToRawSqlMap = new HashMap<SimpleCache.MAPTYPE, String>();

    public static final String SELECT_BY_CRITERIA = "com.toluene.commonbatis.dao.mapper.CommonDaoMapper.selectByCriteria";
    public static final String SELECT_BY_PRIMARYKEY = "com.toluene.commonbatis.dao.mapper.CommonDaoMapper.selectByPrimaryKey";
    public static final String COUNT_CRITERIA = "com.toluene.commonbatis.dao.mapper.CommonDaoMapper.countByCriteria";
    public static final String DELETE_BY_PRIMARYKEY = "com.toluene.commonbatis.dao.mapper.CommonDaoMapper.deleteByPrimaryKey";
    public static final String INSERT = "com.toluene.commonbatis.dao.mapper.CommonDaoMapper.insert";
    public static final String UPDATE_BY_CRITERIA = "com.toluene.commonbatis.dao.mapper.CommonDaoMapper.updateByCriteria";
    public static final String UPDATE_BY_PRIMARYKEY = "com.toluene.commonbatis.dao.mapper.CommonDaoMapper.updateByPrimaryKey";

    private static final String SELECT_RAW_PRESTATEMENT = "select * from @tableName@";
    private static final String COUNT_RAW_PRESTATEMENT = "select count(*) from @tableName@";
    private static final String DEL_RAW_PRESTATEMENT = "delete from @tableName@";
    private static final String INSERT_RAW_PRESTATEMENT = "insert into @tableName@";
    private static final String UPDATE_RAW_PRESTATEMENT = "update @tableName@";

    static {
        sqlIdToCacheMap.put(SELECT_BY_CRITERIA, SimpleCache.MAPTYPE.SELECT);
        sqlIdToCacheMap.put(SELECT_BY_PRIMARYKEY, SimpleCache.MAPTYPE.SELECT);
        sqlIdToCacheMap.put(COUNT_CRITERIA, SimpleCache.MAPTYPE.COUNT);
        sqlIdToCacheMap.put(DELETE_BY_PRIMARYKEY, SimpleCache.MAPTYPE.DEL);
        sqlIdToCacheMap.put(INSERT, SimpleCache.MAPTYPE.INSERT);
        sqlIdToCacheMap.put(UPDATE_BY_CRITERIA, SimpleCache.MAPTYPE.UPDATE);
        sqlIdToCacheMap.put(UPDATE_BY_PRIMARYKEY, SimpleCache.MAPTYPE.UPDATE);

        MapTypeToRawSqlMap.put(SimpleCache.MAPTYPE.SELECT, SELECT_RAW_PRESTATEMENT);
        MapTypeToRawSqlMap.put(SimpleCache.MAPTYPE.COUNT, COUNT_RAW_PRESTATEMENT);
        MapTypeToRawSqlMap.put(SimpleCache.MAPTYPE.DEL, DEL_RAW_PRESTATEMENT);
        MapTypeToRawSqlMap.put(SimpleCache.MAPTYPE.INSERT, INSERT_RAW_PRESTATEMENT);
        MapTypeToRawSqlMap.put(SimpleCache.MAPTYPE.UPDATE, UPDATE_RAW_PRESTATEMENT);
    }

    @SuppressWarnings("unchecked")
    public static Set<String> getElementsSet(String elementName, String path) throws SAXException {
        if (elementName == null || path == null) {
            throw new RuntimeException();
        }
        Set<String> elementValueSet = new TreeSet<String>();
        SAXReader reader = new SAXReader();
        ignoreDTDValidate(reader);
        Document document = null;
        try {
            document = reader.read(new ClassPathResource(path).getInputStream());
        } catch (DocumentException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Element root;
        if (document != null) {
            root = document.getRootElement();
        } else {
            throw new RuntimeException("parser commonDaoMapper.xml error, please check!");
        }
        String prefix = root.attributeValue("namespace");
        List<Element> sqls = (List<Element>) root.elements();
        for (Element sql : sqls) {
            String id = sql.attributeValue(elementName);
            String fixedId = prefix + "." + id;
            elementValueSet.add(fixedId);
        }
        return elementValueSet;
    }

    private static void ignoreDTDValidate(SAXReader reader) throws SAXException {
        reader.setFeature("http://apache.org/xml/features/nonvalidating/load-external-dtd", false);
    }

    public static Map<String, SimpleCache.MAPTYPE> getSqlIdToCacheMap() {
        return Collections.unmodifiableMap(sqlIdToCacheMap);
    }

    public static Map<SimpleCache.MAPTYPE, String> getMapTypeToRawSqlMap() {
        return Collections.unmodifiableMap(MapTypeToRawSqlMap);
    }
}
