package com.wjh.basic.object;

import com.wjh.basic.text.StringUtil;

public class ObjectUtil {
    public static boolean isBlank(Object v) {
        if (v instanceof String) return StringUtil.isBlank((String) v);
        return v == null;
    }
}
