package cn.topicstudy.jutil.basic.error;

/**
 * 功能：抛出指定errorCode，指定errorMsg的异常
 */
public class CommonAssertUtil {
    /**
     * if condition is true, then throws Exception
     *
     * @param condition
     * @param errorCodeEnum
     * @param params
     */
    public static void throwException(boolean condition, BaseErrorCodeEnum errorCodeEnum, Object... params) {
        if (condition) {
            throw new BizException(errorCodeEnum, params);
        }
    }

    /**
     * 用于调下游服务时传递下游服务返的errorCode
     *
     * @param condition
     * @param errorCode
     * @param errorMsg
     */
    public static void throwException(boolean condition, String errorCode, String errorMsg) {
        if (condition) {
            throw new BizException(errorCode, errorMsg);
        }
    }
}
