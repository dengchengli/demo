package springcloud.demo.annotation;

/**
 * @Author: Dely
 * @Date: 2019/12/8 20:59
 */


import java.lang.annotation.*;

/**
 * 注解定义：
 */
@Retention(RetentionPolicy.RUNTIME)
@Repeatable(Bases.class)
@Inherited
public @interface BaseAnnotation {
    int id () default 11;
    String msg() default "struibg";
}
