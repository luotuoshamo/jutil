package cn.topicstudy.jutil.validation.constraint;

import java.lang.annotation.*;
import java.util.SplittableRandom;

@Target(ElementType.FIELD)
@Inherited
@Retention(RetentionPolicy.RUNTIME)
public @interface Range {
    /**
     * exclusive
     *
     * @return
     */
    String max();

    /**
     * inclusive
     *
     * @return
     */
    String min();

    Class<? extends Number> numberType();

    String message() default "";

    String errorCode() default "";

}
