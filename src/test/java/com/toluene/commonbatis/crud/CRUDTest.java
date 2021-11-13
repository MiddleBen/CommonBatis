package com.toluene.commonbatis.crud;


import com.toluene.commonbatis.Criteria;
import com.toluene.commonbatis.OrCriteria;
import com.toluene.commonbatis.criterion.Restrictions;
import com.toluene.commonbatis.dao.mapper.CommonDaoMapper;
import com.toluene.commonbatis.plugin.Transfer;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.math.BigDecimal;
import java.util.List;

public class CRUDTest {

    private static ApplicationContext context;
    private static SqlSessionTemplate sessionTemplate;
    private static CommonDaoMapper commonDaoMapper;

    /**
     * TODO simple test ，however we should rewrite it in JUNIT etc for a comprehensive exam;
     *
     * @param args
     */
    public static void main(String[] args) {
        try {
            context = new ClassPathXmlApplicationContext(
                    "applicationContext.xml");
        } catch (Exception e) {
            e.printStackTrace();
            // TODO: handle exception
        }
        //test plugin
        sessionTemplate = context
                .getBean(SqlSessionTemplate.class);
        sessionTemplate.getConfiguration().addInterceptor(new Transfer());
        commonDaoMapper = context.getBean(CommonDaoMapper.class);
        testSelectByCriteria();
        testSelectByPrimaryKey();
        testCountByCriteria();
        testDeleteByCriteria();
        testDeleteByCriteria();
        testInsert();
        testUpdateByCriteriat();
        testUpdateByPrimaryKey();

        testSelectByCriteria();
        testSelectByPrimaryKey();
        testCountByCriteria();
        testDeleteByCriteria();
        testDeleteByCriteria();
        testUpdateByCriteriat();
        testUpdateByPrimaryKey();
    }

    private static void testSelectByCriteria() {
        System.out.println("--------------start to test selectByCriteria--------------------");
        //selectByPrimaryKey //
        OrCriteria orCriteria = new OrCriteria();
        Criteria criteria = new Criteria();
        criteria.add(Restrictions.eq("linenum", 10));
        orCriteria.add(criteria);
        List<Lineitem> lineitem2 = commonDaoMapper.selectByCriteria(Lineitem.class, orCriteria);
        for (Lineitem item : lineitem2) {
            System.out.println(item);
        }
        System.out.println("---------------end to test selectByCriteria------------------------");
    }

    private static void testSelectByPrimaryKey() {
        System.out.println("--------------start to test selectByPrimaryKey--------------------");
        // selectByPrimaryKey //
        LineitemKey key = new LineitemKey();
        key.setLinenum(10);
        key.setOrderid(12);
        List<Lineitem> lineitem = commonDaoMapper.selectByPrimaryKey(Lineitem.class, key);
        for (Lineitem item : lineitem) {
            System.out.println(item);
        }
        System.out.println("---------------end to test selectByCriteria------------------------");
    }

    private static void testCountByCriteria() {
        // countByCriteria//
        System.out.println("--------------start to test countByCriteria--------------------");
        OrCriteria orCriteria = new OrCriteria();
        Criteria criteria = new Criteria();
        criteria.add(Restrictions.eq("linenum", 10));
        orCriteria.add(criteria);
        int count = commonDaoMapper.countByCriteria(Lineitem.class, orCriteria);
        System.out.println("get count ： " + count);
        System.out.println("---------------end to test selectByCriteria------------------------");
    }

    private static void testDeleteByPrimaryKey() {
        //deleteByPrimaryKey//
        System.out.println("--------------start to test deleteByPrimaryKey--------------------");
        LineitemKey key = new LineitemKey();
        key.setLinenum(1);
        int ret = commonDaoMapper.deleteByPrimaryKey(Lineitem.class, key);
        System.out.println(ret);
        System.out.println("---------------end to test deleteByPrimaryKey------------------------");
    }

    private static void testDeleteByCriteria() {
        //deleteByCriteria//
        System.out.println("--------------start to test deleteByCriteria--------------------");
        OrCriteria orCriteria = new OrCriteria();
        Criteria criteria = new Criteria();
        criteria.add(Restrictions.eq("linenum", 2));
        orCriteria.add(criteria);
        int count = commonDaoMapper.countByCriteria(Lineitem.class, orCriteria);
        System.out.println("sum of del ： " + count);
        System.out.println("---------------end to test deleteByCriteria------------------------");
    }

    private static void testInsert() {
        //insert//
        System.out.println("--------------start to test insert--------------------");
        Lineitem lineitem = new Lineitem();
        lineitem.setItemid(100 + "");
        lineitem.setQuantity(122);
        lineitem.setUnitprice(new BigDecimal(111));
        lineitem.setLinenum(222);
        lineitem.setOrderid(22);
        Lineitem lineitem2 = new Lineitem();
        lineitem2.setItemid(100 + "3q");
        lineitem2.setQuantity(1223);
        lineitem2.setUnitprice(new BigDecimal(1113));
        lineitem2.setLinenum(2223);
        lineitem2.setOrderid(223);
        int i = commonDaoMapper.insert(lineitem);
        System.out.println("add row sum: " + i);
        int j = commonDaoMapper.insert(lineitem2);
        System.out.println("add row sum: " + j);
        System.out.println("---------------end to test insert------------------------");
    }

    private static void testUpdateByCriteriat() {
        //updateByCriteria
        System.out.println("--------------start to test updateByCriteria--------------------");
        OrCriteria orCriteria = new OrCriteria();
        Criteria criteria = new Criteria();
        criteria.add(Restrictions.eq("linenum", 2));
        orCriteria.add(criteria);
        Lineitem lineitem = new Lineitem();
        lineitem.setItemid("1111111");
        int count = commonDaoMapper.updateByCriteria(lineitem, orCriteria);
        System.out.println("update count ： " + count);
        System.out.println("---------------end to test updateByCriteria------------------------");
    }

    private static void testUpdateByPrimaryKey() {
        //updateByPrimaryKey
        System.out.println("--------------start to test updateByPrimaryKey--------------------");
        LineitemKey lineitemKey = new Lineitem();
        lineitemKey.setOrderid(1);
        Lineitem lineitem = new Lineitem();
        lineitem.setItemid("11555551");
        int count = commonDaoMapper.updateByPrimaryKey(lineitem, lineitemKey);
        System.out.println("update count ： " + count);
        System.out.println("---------------end to test updateByPrimaryKey------------------------");
    }
}
