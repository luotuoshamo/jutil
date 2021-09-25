package com.wjh.basic.map;

import com.wjh.basic.file.FileUtil;
import com.wjh.basic.text.StringUtil;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

/**
 * .properties文件工具类
 * .properties文件可看成map
 */
public class PropertiesUtil {
    /**
     * 将.properties文件内容转成Map<String,String>
     * 如果为空白返回空map
     * <p>
     * // JDK提供的API写法无法取出k,v左右的空格
     * Properties properties = new Properties();
     * properties.load(new FileInputStream(propertiesFile));
     * <p>
     * Enumeration<String> enumeration = (Enumeration<String>) properties.propertyNames();
     * while (enumeration.hasMoreElements()) {
     * String name = enumeration.nextElement();
     * map.put(name, properties.getProperty(name));
     * }
     */
    public static Map<String, String> parseToMap(File propertiesFile) throws IOException {
        Map<String, String> map = new HashMap();
        if (propertiesFile == null || propertiesFile.isDirectory() || !propertiesFile.exists()) return map;

        FileReader fr = new FileReader(propertiesFile);
        BufferedReader br = new BufferedReader(fr);
        while (true) {
            String line = br.readLine();
            if (line == null) break;
            line = StringUtil.deepTrim(line);
            if (StringUtil.isBlank(line) || line.startsWith("#")) continue; // 空行、注释
            String[] split = line.split("=");
            String key = StringUtil.deepTrim(split[0]);// trim()防止key value前后的空格干扰
            String value = StringUtil.deepTrim(split[1]);
            map.put(key, value);
        }

        if (br != null) br.close();
        if (fr != null) fr.close();
        return map;
    }
}
