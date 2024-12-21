package cn.topicstudy.jutil.validation.constraint;

import java.lang.annotation.*;

@Target(ElementType.FIELD)
@Inherited
// RUNTIME才能在运行时拿到注解
@Retention(RetentionPolicy.RUNTIME)
public @interface NotEmpty {
    String message() default "The collect can not be empty.";
    String errorCode() default "PARAM_IS_EMPTY";
}
