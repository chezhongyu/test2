package com.foreknow.mapping;

import java.util.HashMap;
import java.util.Map;

/**
 * 工厂类：主要作用是用来管理mapping类
 *
 * 单例模式：提高效率，节省内存空间
 */
public class MappingFactory {
    private static MappingFactory mappingFactory= null;
    private Map<String,EntityMapping> maps = new HashMap<>();
    //有一个xxxMapping就建一个常量
    public  static final String ADMIN_MAPPING = "adminMapping";
    public  static final String GUEST_MAPPING = "guestMapping";
    public  static final String STAFF_MAPPING = "staffMapping";

    private MappingFactory(){}
    public static MappingFactory getMappingFactory() {
        if(mappingFactory==null){
            mappingFactory=new MappingFactory();
            //向Map集合中保存Mapping对象
            //有一个xxxMapping就添加一个mappingFactory.maps.put(    ，new xxxMapping())
            mappingFactory.maps.put(ADMIN_MAPPING,new AdminMapping());
            mappingFactory.maps.put(GUEST_MAPPING,new GuestbookMapping());
            mappingFactory.maps.put(STAFF_MAPPING,new StaffMapping());
        }
        return mappingFactory;
    }

    /**
     * 从Map集合中根据key获取到xxxMapping对象
     * 因为这些xxxdMapping对象都实现了EntityMapping接口
     * @param key
     * @return  EntityMapping（接口，父类型）多态
     */
    public EntityMapping getMap(String key){


        return maps.get(key);



}

}
