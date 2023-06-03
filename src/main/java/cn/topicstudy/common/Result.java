package cn.topicstudy.common;

/**
 * 统一格式的结果
 */
@Deprecated
public class Result {
    private Boolean success;
    private String msg;

    public Result(Boolean success, String msg) {
        this.success = success;
        this.msg = msg;
    }

    public Boolean getSuccess() {
        return success;
    }

    public String getMsg() {
        return msg;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
