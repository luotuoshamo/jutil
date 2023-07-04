package cn.topicstudy.basic.exception;

public class CommonAssertUtil {
    public static void throwException(boolean condition, BaseErrorCodeEnum errorCodeEnum, Object... params) {
        if (condition) {
            // TODO: 2023/6/11 替换成自己项目中继承自BaseRuntimeException的类
            throw new BaseRuntimeException(errorCodeEnum, params);
        }
    }
}
