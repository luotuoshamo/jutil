package cn.topicstudy.jutil.error;

import java.text.MessageFormat;

public class TSChatException extends RuntimeException {

    String errorCode;
    String errorMsg;

    public TSChatException(TSChatErrorCodeEnum errorCodeEnum, Object... params) {
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
