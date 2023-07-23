package cn.topicstudy.jutil.basic.exception;

import java.text.MessageFormat;

public class BaseRuntimeException extends RuntimeException {
    String errorCode;
    String errorMsg;

    public BaseRuntimeException(BaseErrorCodeEnum errorCodeEnum, Object... params) {
        super(errorCodeEnum.getErrorMsg());
        String errorMsg = errorCodeEnum.getErrorMsg();
        String newErrorMsg = MessageFormat.format(errorMsg, params);
        this.errorCode = errorCodeEnum.getErrorCode();
        this.errorMsg = newErrorMsg;
    }

    public String getErrorCode() {
        return errorCode;
    }

    public String getErrorMsg() {
        return errorMsg;
    }
}
