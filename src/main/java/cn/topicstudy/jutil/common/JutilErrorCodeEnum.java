package cn.topicstudy.jutil.common;

import cn.topicstudy.jutil.basic.error.BaseErrorCodeEnum;

public enum JutilErrorCodeEnum implements BaseErrorCodeEnum {
    SYS_ERROR("TS-jutil-0-0", "系统错误"),

    /**
     * validation
     */
    VALIDATION_OBJ_IS_NULL("TS-jutil-validation-0", "校验属性时，参数为空"),

    ;
    private String errorCode;
    private String errorMsg;

    JutilErrorCodeEnum(String errorCode, String errorMsg) {
        this.errorCode = errorCode;
        this.errorMsg = errorMsg;
    }

    @Override
    public String getErrorCode() {
        return errorCode;
    }

    @Override
    public String getErrorMsg() {
        return errorMsg;
    }
}
