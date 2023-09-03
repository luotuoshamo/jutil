package cn.topicstudy.jutil.validation;

import java.util.List;

public interface ConstraintValidator {
    List<ConstraintUnsatisfiedInfo> validate(Object obj);
}
