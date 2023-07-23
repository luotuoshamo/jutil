package cn.topicstudy.jutil.error;

public enum TSChatErrorCodeEnum {
    // 公共：1
    SYS_ERROR("TS-CHAT-1", "系统异常"),
    PARAM_CAN_NOT_BE_NULL("TS-CHAT-11", "{0}不可为空"),

    // 用户&登录：2
    NOT_LOGIN("TS-CHAT-2-1", "未登录"),
    REG_MISS_ARG("TS-CHAT-2-2", "注册失败，参数为空，参数：{0}"),
    EXIST_MANY_USER_WITH_SAME_NAME("TS-CHAT-13", "该用户名（{0}）存在多个用户"),
    USER_ALREADY_EXISTED("TS-CHAT-14", "用户名（{0}）已存在"),
    TXT_TO_LONG("TS-CHAT-15", "{0}过长，最大长度：{1}"),
    USER_NOT_EXIST("TS-CHAT-16", "用户名不存在"),
    PWD_ERROR("TS-CHAT-17", "密码不正确"),
    FIND_MORE_THAN_ONE_USER_BY_CLIENT_TOKEN("TS-CHAT-18", "根据登录信息找到多个相同用户"),
    TS_CLIENT_TOKEN_FORMAL_ERROR("TS-CHAT-19", "登录信息格式不正确"),
    TS_CLIENT_TOKEN_EXPIRED("TS-CHAT-20", "登录信息已过期"),
    TS_CLIENT_TOKEN_NOT_EXISTED("TS-CHAT-20", "登录信息不存在"),

    // chat：3
    CHAT_GPT_API_RESPONSE_NULL("TS-CHAT-3-1", "chatGPT接口响应为空"),
    CHAT_GPT_API_RESPONSE_ERROR("TS-CHAT-3-2", "chatGPT接口响应失败，失败信息：{0}"),

    // 操作日志：4
    ADD_OPERATE_LOG_MISS_ARG("TS-CHAT-4-1", "记操作日志失败，缺少参数，参数:{0}"),

    ;
    private String errorCode;
    private String errorMsg;

    private TSChatErrorCodeEnum(String errorCode, String errorMsg) {
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
