package com.wjh.core.basic.map;

import java.util.HashMap;
import java.util.Map;

public class MapUtil {
    /**
     * 将Map的k v调换
     * 例如 map={k1:v1,k2:v2} 返回{v1:k1,v2:k2}
     *
     * @return 新的map 该map的k v和参数map相反
     */
    public static Map<Object, Object> reverseMap(Map<Object, Object> map) {
        Map<Object, Object> m = new HashMap<>();
        for (Object k : map.keySet()) {
            m.put(map.get(k), k);
        }
        return m;
    }

    public static void main(String[] args) {
        Map m = new HashMap<>();
        m.put("name","wjh");
        m.put("age",10);
        Map<Object, Object> objectObjectMap = reverseMap(m);
        System.out.println(objectObjectMap);

    }
}
