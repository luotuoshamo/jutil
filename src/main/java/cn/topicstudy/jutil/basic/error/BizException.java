package cn.topicstudy.jutil.basic.error;

import java.text.MessageFormat;

public class BizException extends RuntimeException {
    String errorCode;
    String errorMsg;

    public BizException(BaseErrorCodeEnum errorCodeEnum, Object... params) {
        super(MessageFormat.format(errorCodeEnum.getErrorMsg(), params));
        String errorMsg = errorCodeEnum.getErrorMsg();
        String newErrorMsg = MessageFormat.format(errorMsg, params);
        this.errorCode = errorCodeEnum.getErrorCode();
        this.errorMsg = newErrorMsg;
    }

    public BizException(BaseErrorCodeEnum errorCodeEnum, Throwable cause, Object... params) {
        super(MessageFormat.format(errorCodeEnum.getErrorMsg(), params), cause);
        String errorMsg = errorCodeEnum.getErrorMsg();
        String newErrorMsg = MessageFormat.format(errorMsg, params);
        this.errorCode = errorCodeEnum.getErrorCode();
        this.errorMsg = newErrorMsg;
    }

    public BizException(String errorCode, String errorMsg) {
        this.errorCode = errorCode;
        this.errorMsg = errorMsg;
    }

    public BizException(String errorCode, String errorMsg, Throwable cause) {
        super(cause);
        this.errorCode = errorCode;
        this.errorMsg = errorMsg;

    }

    public String getErrorCode() {
        return errorCode;
    }

    public String getErrorMsg() {
        return errorMsg;
    }
}
