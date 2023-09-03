package cn.topicstudy.jutil.validation.constraint;

import java.lang.annotation.*;

@Target(ElementType.FIELD)
@Inherited
@Retention(RetentionPolicy.RUNTIME)
public @interface Length {
    long max() default Long.MAX_VALUE;

    long min() default 0;

    String message() default "";
}
