package cn.topicstudy.jutil.basic.error;


public enum JutilErrorCodeEnum implements BaseErrorCodeEnum {
    SYS_ERROR("TS-jutil-0-0", "系统错误"),

    /**
     * validation:1
     */
    VALIDATION_OBJ_IS_NULL("U-TS-JUTIL-1-0", "校验属性时，参数为空"),

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
