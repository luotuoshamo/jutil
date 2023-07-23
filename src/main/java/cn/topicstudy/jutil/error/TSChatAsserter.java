package cn.topicstudy.jutil.error;

import cn.topicstudy.jutil.basic.text.StringUtil;

public class TSChatAsserter {
    public static void notNull(Object o, Object... params) {
        if (o == null) {
            throw new TSChatException(TSChatErrorCodeEnum.PARAM_CAN_NOT_BE_NULL, params);
        }
    }

    public static void notBlank(String o, Object... params) {
        if (StringUtil.isBlank(o)) {
            throw new TSChatException(TSChatErrorCodeEnum.PARAM_CAN_NOT_BE_NULL, params);
        }
    }

    public static void throwException(boolean condition, TSChatErrorCodeEnum errorCodeEnum, Object... params) {
        if (condition) {
            throw new TSChatException(errorCodeEnum, params);
        }
    }
}
