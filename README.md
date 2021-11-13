##CommonBatis

a mybatis plugin that provide common dao. you even don't need any xml or interface to manipulate database. 
i.e. with this plugin you can use mybatis in criteria serach like hibernate~
mybatis is a great framework. nevertheless, it just encapsulate data access layer, for us to do some of the object-relational mapping. The expense of having to write xml configuration file. 
relative to Hibernate we have to write a lot of SQL.in most cases we do not need to write sql will be greatly improved development efficiency. many people may suggest that we can use mybatis-generator. so. i had a try. from a five columns table,it generated 5 files with more than 800 lines of code! it's much more than i can bear.Hibernate is very powerful, perfect ORM framework, but this is its strength is also its shortcomings.so, in order to fill this gap. i write this plugin for mybatis.the plugin working well now. but also there are many problem should be repaired in the months ahead, any pull request will be pleasure!

#Example

    step 1: 
        use mybatis-generator-core-1.3.2 generate entities. delete all other files, 
        like XX.xml, XXExample and Mapper.jva. then you get entities only. like this :
        
        public class LineitemKey {
            private Integer orderid;
            private Integer linenum;
            ...(getter and setter) 
            }
        
        public class Lineitem extends LineitemKey {
            private String itemid;
            private Integer quantity;
            private BigDecimal unitprice;
             ...(getter and setter) 
            }
            
    step 2:
        config this plugin into you Configuration. such as :
        sessionTemplate.getConfiguration().addInterceptor(new Transfer());
        class Transfer is our plugin.
        
    step 3:
        then we can start our crud operations now. no xml,no interface,no configure files any more.
        just start it！ search by criteria :
        
            OrCriteria orCriteria = new OrCriteria();
            Criteria criteria = new Criteria();
            criteria.add(Restrictions.eq("linenum", 10));
            orCriteria.add(criteria);
            List<Lineitem> lineitem2 = commonDaoMapper.selectByCriteria(Lineitem.class, orCriteria);
            for (Lineitem item : lineitem2) {
                System.out.println(item);
            }
            
        search by PrimaryKey:
        
            LineitemKey key = new LineitemKey();
            key.setLinenum(10);
            key.setOrderid(12);
            List<Lineitem> lineitem = commonDaoMapper.selectByPrimaryKey(Lineitem.class, key);
            for (Lineitem item : lineitem) {
                System.out.println(item);
            }
        etc.it's looked the same as hibernate's criteria right? but it's base on mybatis actually.
        and many other operations you can reference the test case in this project.last by not least,
        the plugin is not a comprehensive solution. in some sepcial situations, such as high 
        performance complex sql search in need,you'd better write your own mappering instead!
    
