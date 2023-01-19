package cn.topicstudy.entity;

import java.io.Serializable;

public class CommonResult<T> implements Serializable {
    private static final long serialVersionUID = 0;

    private Boolean isSuccess;
    private String errorCode;
    private String errorMsg;
    private T data;

    private Integer total;
    private Integer page;
    private Integer pageSize;

    public Boolean isSuccess() {
        return isSuccess;
    }

    public CommonResult ofSuccess(T data) {
        CommonResult commonResult = new CommonResult();
        commonResult.setSuccess(true);
        commonResult.setData(data);
        return commonResult;
    }

    public CommonResult ofSuccess() {
        CommonResult commonResult = new CommonResult();
        commonResult.setSuccess(true);
        return commonResult;
    }

    public CommonResult ofError(String errorCode, String errorMsg) {
        CommonResult commonResult = new CommonResult();
        commonResult.setSuccess(false);
        commonResult.setErrorCode(errorCode);
        commonResult.setErrorMsg(errorMsg);
        return commonResult;
    }

    public void setSuccess(Boolean success) {
        isSuccess = success;
    }

    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    public String getErrorMsg() {
        return errorMsg;
    }

    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("{");
        sb.append("\"isSuccess\":")
                .append(isSuccess);
        sb.append(",\"errorCode\":\"")
                .append(errorCode).append('\"');
        sb.append(",\"errorMsg\":\"")
                .append(errorMsg).append('\"');
        sb.append(",\"data\":")
                .append(data);
        sb.append(",\"total\":")
                .append(total);
        sb.append(",\"page\":")
                .append(page);
        sb.append(",\"pageSize\":")
                .append(pageSize);
        sb.append('}');
        return sb.toString();
    }
}
