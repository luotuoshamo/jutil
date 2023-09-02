package cn.topicstudy.jutil.basic.error;

public enum TestJUtilErrorCodeEnum implements BaseErrorCodeEnum {
    ERROR1("TS-jutil-1-1","测试错误码，参数1：{0}，参数2：{1}"),

        ;
    private String errorCode;
    private String errorMsg;

    TestJUtilErrorCodeEnum(String errorCode, String errorMsg) {
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
