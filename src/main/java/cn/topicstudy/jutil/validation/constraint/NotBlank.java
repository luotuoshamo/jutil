package cn.topicstudy.jutil.validation.constraint;

import java.lang.annotation.*;

@Target(ElementType.FIELD)
@Inherited
@Retention(RetentionPolicy.RUNTIME)
public @interface NotBlank {
    String message() default "不可为空";
    String errorCode() default "PARAM_IS_BLANK";
}
