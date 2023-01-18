package cn.topicstudy.basic.object;

import cn.topicstudy.basic.text.StringUtil;

public class ObjectUtil {
    public static boolean isBlank(Object v) {
        if (v instanceof String) return StringUtil.isBlank((String) v);
        return v == null;
    }
}
