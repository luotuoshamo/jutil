package cn.topicstudy.jutil.validation.constraint;


import java.lang.annotation.*;

@Target(ElementType.FIELD)
@Inherited
@Retention(RetentionPolicy.RUNTIME)
public @interface NotNull {
    String message() default "";

    String errorCode() default "";
}
