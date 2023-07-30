package cn.topicstudy.jutil.basic.error;

import java.text.MessageFormat;

/**
 * 业务异常（与之对应的是系统异常）
 */
public class BizException extends RuntimeException {
    String errorCode;
    String errorMsg;

    public BizException(BaseErrorCodeEnum errorCodeEnum, Object... params) {
        super(errorCodeEnum.getErrorMsg());
        String errorMsg = errorCodeEnum.getErrorMsg();
        String newErrorMsg = MessageFormat.format(errorMsg, params);
        this.errorCode = errorCodeEnum.getErrorCode();
        this.errorMsg = newErrorMsg;
    }

    public BizException(String errorCode, String errorMsg) {
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
