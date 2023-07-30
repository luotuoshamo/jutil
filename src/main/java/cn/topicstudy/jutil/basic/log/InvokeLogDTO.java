package cn.topicstudy.jutil.basic.log;

import cn.topicstudy.jutil.entity.BaseDTO;
import lombok.Data;

import java.util.List;

/**
 * 记接口调用时的日志信息
 */
@Data
public class InvokeLogDTO extends BaseDTO {
    /**
     * 被调接口标识：className+methodName
     */
    private String className;
    private String methodName;

    /**
     * 调用是否成功
     */
    private Boolean isSuccess;

    /**
     * 调用耗时，从开始调用到获得结果
     */
    private long milliCost;

    /**
     * 入参
     */
    private List<Object> inArgs;

    /**
     * 出参
     */
    private Object out;
    private String traceId;

    /**
     * 调用者，前端网关对应userId，内部调用对应调用者appName
     */
    private String invokerId;
    private String invokerDesc;
    private String errorCode;
    private String errorMsg;
    private String exceptionStack;
    private String invokerIP;
}
