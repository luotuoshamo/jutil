package cn.topicstudy.jutil.basic.error;

/**
 * errorCode枚举基类，项目中定义errorCode枚举时实现该接口
 */
public interface BaseErrorCodeEnum {
    String getErrorCode();
    String getErrorMsg();
}
