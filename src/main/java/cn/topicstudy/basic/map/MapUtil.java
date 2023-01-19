package cn.topicstudy.basic.map;

import cn.topicstudy.basic.text.StringUtil;

import java.beans.BeanInfo;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

public class MapUtil {
    /**
     * 将Map的k v调换
     * 例如 map={k1:v1,k2:v2} 返回{v1:k1,v2:k2}
     *
     * @return 新的map 该map的kv和输入map的相反
     */
    public static Map<Object, Object> reverseKV(Map<Object, Object> map) {
        Map<Object, Object> m = new HashMap<>();
        for (Object k : map.keySet()) m.put(map.get(k), k);
        return m;
    }

    /**
     * map转bean
     * 使用内省实现
     *
     * @param beanClass bean的类型，bean是标准实体类（熟悉+get+set）
     */
    public static <T> T mapToBean(Map<String, Object> map, Class<T> beanClass) throws Exception {
        if (map == null || map.isEmpty() || beanClass == null) return null;

        T instance = beanClass.newInstance();
        BeanInfo beanInfo = Introspector.getBeanInfo(beanClass, Object.class);
        PropertyDescriptor[] propertyDescriptors = beanInfo.getPropertyDescriptors();
        for (PropertyDescriptor propertyDescriptor : propertyDescriptors) {
            String name = propertyDescriptor.getName();
            Method writeMethod = propertyDescriptor.getWriteMethod();
            writeMethod.invoke(instance, map.get(name));
        }
        return instance;
    }

    /**
     * bean转map
     */
    public static <T> Map<String, Object> beanToMap(T beanInstance, Class<T> beanClass) throws Exception {
        if (beanClass == null || beanInstance == null) return null;

        Map<String, Object> map = new HashMap<>();
        BeanInfo beanInfo = Introspector.getBeanInfo(beanClass, Object.class);
        PropertyDescriptor[] propertyDescriptors = beanInfo.getPropertyDescriptors();
        for (PropertyDescriptor propertyDescriptor : propertyDescriptors) {
            String name = propertyDescriptor.getName();
            Method readMethod = propertyDescriptor.getReadMethod();
            Object value = readMethod.invoke(beanInstance);
            map.put(name, value);
        }

        return map;
    }

    /**
     * k1=v1&k2=v2  * @param queryStr  * @return must not null
     */
    public static Map<String, String> queryStr2Map(String queryStr) {
        Map<String, String> map = new HashMap<>();
        if (StringUtil.isBlank(queryStr)) {
            return map;
        }
        String[] kvList = queryStr.split("&");
        if (kvList == null || kvList.length == 0) {
            return map;
        }
        for (String kv : kvList) {
            String[] kvArr = kv.split("=");
            String k = kvArr[0];
            String v = kvArr[1];
            map.put(k, v);
        }
        return map;
    }

    /**
     * * @param map  * @return must not null
     */
    public static String map2QueryStr(Map<String, String> map) {
        String queryStr = "";
        if (map == null || map.isEmpty()) {
            return queryStr;
        }
        for (Map.Entry<String, String> entry : map.entrySet()) {
            String kv = entry.getKey() + "=" + entry.getValue();
            queryStr = queryStr + "&" + kv;
        }
        return queryStr.substring(1);
    }
}
