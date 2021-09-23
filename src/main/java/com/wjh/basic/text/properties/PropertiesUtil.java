package com.wjh.basic.text.properties;

import com.wjh.basic.text.StringUtil;

import java.io.File;
import java.io.FileInputStream;
import java.util.HashMap;
import java.util.Map;

/**
 * .properties文件工具类
 * .properties文件可看成是数据库中的表
 */
public class PropertiesUtil {
    /**
     * 将.properties文件转成Map<String,String>
     * 如果为空白返回空map
     */
    public static Map<String, String> parse(File propertiesFile) throws Exception {
        Map<String, String> map = new HashMap();
        FileInputStream fis = new FileInputStream(propertiesFile);
        int available = fis.available();

        byte[] byteArray = new byte[available];
        fis.read(byteArray);
        String s = new String(byteArray).trim();// 去掉开头和结尾的空格、空行
        if (StringUtil.isBlank(s)) return map;
        String[] lines = s.split("\n");
        for (String line : lines) {
            // 空行、注释
            if (StringUtil.isBlank(line) || line.trim().startsWith("#")) {
                continue;
            }
            String[] split = line.split("=");
            String key = split[0].trim();// trim()防止key value前后的空格干扰
            String value = split[1].trim();
            map.put(key, value);
        }
        if (fis != null) fis.close();
        return map;

     /*   JDK提供的API写法无法取出k,v左右的空格
        Properties properties = new Properties();
        properties.load(new FileInputStream(propertiesFile));

        Enumeration<String> enumeration = (Enumeration<String>) properties.propertyNames();
        while (enumeration.hasMoreElements()) {
            String name = enumeration.nextElement();
            map.put(name, properties.getProperty(name));
        }*/
    }


    public static void set(File propertiesFile, String key, String value) {

    }


    public static String get(File propertiesFile, String key) {

        return null;
    }
}
