package cn.topicstudy.jutil.basic.error;


public enum JutilErrorCodeEnum implements BaseErrorCodeEnum {
    SYS_ERROR("TS-jutil-0-0", "Unknown error."),

    /**
     * validation
     */
    VALIDATION_OBJ_IS_NULL("U-TS-JUTIL-VALIDATION-0", "The object can't be null."),

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
