package com.toluene.commonbatis.util;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.util.Assert;
import org.springframework.util.ReflectionUtils;

@SuppressWarnings("unchecked")
public class ReflectionUtil extends ReflectionUtils {

    public static List<Field> getAllFields(Class clazz) {
        Assert.notNull(clazz, "Class must not be null");
        Class<?> searchType = clazz;
        List<Field> liFields = new ArrayList<Field>();
        while (!Object.class.equals(searchType) && searchType != null) {
            Field[] fields = searchType.getDeclaredFields();
            for (Field field : fields) {
                if ("serialVersionUID".equals(field.getName())) {
                    continue;
                }
                makeAccessible(field);
                liFields.add(field);
            }
            searchType = searchType.getSuperclass();
        }
        return liFields;
    }

    public static void setTarget(Object obj, Object value, String name) {
        Field field = findField(obj.getClass(), name);
        field.setAccessible(true);
        setField(field, obj, value);
    }

    public static Object getFieldValue(Object obj, String fieldName) {
        Field field = findField(obj.getClass(), fieldName);
        field.setAccessible(true);
        return getField(field, obj);
    }
}