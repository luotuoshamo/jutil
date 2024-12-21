package cn.topicstudy.jutil.validation.constraint;


import java.lang.annotation.*;

@Target(ElementType.FIELD)
@Inherited
@Retention(RetentionPolicy.RUNTIME)
public @interface NotNull {
    String message() default "The field can not be null.";

    String errorCode() default "PARAM_IS_NULL";
}
