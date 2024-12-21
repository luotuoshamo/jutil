package cn.topicstudy.jutil.validation;

import java.util.List;

public interface ConstraintValidator {
    @Deprecated
    void validate(Object obj);

    void validate(Object obj, String errorCode);
}
