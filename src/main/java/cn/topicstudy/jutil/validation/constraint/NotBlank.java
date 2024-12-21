package cn.topicstudy.jutil.validation.constraint;

import java.lang.annotation.*;

@Target(ElementType.FIELD)
@Inherited
@Retention(RetentionPolicy.RUNTIME)
public @interface NotBlank {
    String message() default "Field can not be blank.";
    String errorCode() default "PARAM_IS_BLANK";
}
