package cn.topicstudy.jutil.validation.constraint;

import java.lang.annotation.*;

@Target(ElementType.FIELD)
@Inherited
@Retention(RetentionPolicy.RUNTIME)
public @interface Range {
    /**
     * exclusive
     *
     * @return
     */
    long max() default Long.MAX_VALUE;

    /**
     * inclusive
     *
     * @return
     */
    long min() default 0;

    String message() default "";

    String errorCode() default "PARAM_RANGE_UNSUITED";

}
