package com.wjh.basic.text.idCard;

import com.wjh.basic.map.MapUtil;

import java.util.HashMap;
import java.util.Map;

/**
 * 全国的省的工具
 */
public class ProvinceUtil {
    //全国的省 k:省的代码 v:省的名称
    private static Map<String, String> provinceMap = new HashMap();

    static {
        // 初始化全国的省 33个
        provinceMap.put("11", "北京市");
        provinceMap.put("12", "天津市");
        provinceMap.put("13", "河北省");
        provinceMap.put("14", "山西省");
        provinceMap.put("15", "内蒙古自治区");
        provinceMap.put("21", "辽宁省");
        provinceMap.put("22", "吉林省");
        provinceMap.put("23", "黑龙江省");
        provinceMap.put("31", "上海市");
        provinceMap.put("32", "江苏省");
        provinceMap.put("33", "浙江省");
        provinceMap.put("34", "安徽省");
        provinceMap.put("35", "福建省");
        provinceMap.put("36", "江西省");
        provinceMap.put("37", "山东省");
        provinceMap.put("41", "河南省");
        provinceMap.put("42", "湖北省");
        provinceMap.put("43", "湖南省");
        provinceMap.put("44", "广东省");
        provinceMap.put("45", "广西壮族自治区");
        provinceMap.put("46", "海南省");
        provinceMap.put("50", "重庆市");
        provinceMap.put("51", "四川省");
        provinceMap.put("52", "贵州省");
        provinceMap.put("53", "云南省");
        provinceMap.put("54", "西藏自治区");
        provinceMap.put("61", "陕西省");
        provinceMap.put("62", "甘肃省");
        provinceMap.put("63", "青海省");
        provinceMap.put("64", "宁夏回族自治区");
        provinceMap.put("65", "新疆维吾尔自治区");
        provinceMap.put("71", "台湾省");
        provinceMap.put("81", "香港特别行政区");
        provinceMap.put("82", "澳门特别行政区");
    }

    /**
     * 根据省的代码获取省的名称
     *
     * @param code 省的代码 例如 11
     * @return code=11时 返回 北京市
     */
    public static String getProvinceNameByCode(String code) {
        return provinceMap.get(code);
    }

    /**
     * 根据省的名称获取省的代码
     */
    public static String getProvinceCodeByName(String name) {
        Map m = provinceMap;
        return MapUtil.reverseMap(m).get(name).toString();
    }
}
