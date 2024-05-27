package cn.topicstudy.jutil.validation;

import lombok.Data;

@Data
public class ConstraintUnsatisfiedInfo {
    private String fieldName;
    private Object value;
    private String message;
    private String errorCode;

    public ConstraintUnsatisfiedInfo(String fieldName, Object value, String message, String errorCode) {
        this.fieldName = fieldName;
        this.value = value;
        this.message = message;
        this.errorCode = errorCode;
    }
}
