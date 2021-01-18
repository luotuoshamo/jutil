package com.wjh.basic.object;

public class ObjectUtil {
    /**
     * ?п?
     * ?????????null ????true
     * ??????????null "" "  " ????true
     */
    public static boolean isBlank(Object v){
        if(v instanceof String){
            String s = (String)v;
            return v == null || s.trim().isEmpty();
        }
        return v == null;
    }
}
