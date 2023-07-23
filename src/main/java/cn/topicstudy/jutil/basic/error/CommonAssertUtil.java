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
}
