package cn.topicstudy.jutil.entity;

import lombok.Data;

import java.util.List;
import java.util.Map;


@Data
public class CommonResult<T> extends BaseDTO {
    private boolean success;
    private String errorCode;
    private String errorMsg;
    /**
     * 根据错误码平台转换后的errorMsg
     */
    private String customErrorMsg;
    /**
     * 服务提供方给调用方的重试信号，为true表示需要调用方来重试
     */
    private boolean needRetry;
    private int total;
    private T data;
    /**
     * 批处理时：
     * 将处理失败的返回出去，k：单个处理对象标识，v：失败原因
     * 不在failMap，也不在successMap中的对象表示未被处理
     * 全部成功：success=true（考虑靠成功占大部分，为了方便判断）
     * 全部失败、部分成功：success=false
     */
    private Map<String, String> failMap;
    private List<String> successList;

    public static <T> CommonResult ofSuccess(T data) {
        CommonResult commonResult = new CommonResult();
        commonResult.setSuccess(true);
        commonResult.setData(data);
        return commonResult;
    }

    public static CommonResult ofSuccess() {
        CommonResult commonResult = new CommonResult();
        commonResult.setSuccess(true);
        return commonResult;
    }

    public static CommonResult ofError(String errorCode, String errorMsg) {
        CommonResult commonResult = new CommonResult();
        commonResult.setSuccess(false);
        commonResult.setErrorCode(errorCode);
        commonResult.setErrorMsg(errorMsg);
        return commonResult;
    }
}
