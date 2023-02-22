package cn.topicstudy.entity;

import lombok.Data;


@Data
public class CommonResult<T> extends BaseDTO {
    private boolean success;
    private String errorCode;
    private String errorMsg;
    //服务提供方给调用方的重试信号，为true表示需要调用方来重试
    private boolean needRetry;
    private int total;
    private T data;
}
