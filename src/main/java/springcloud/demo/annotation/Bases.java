package springcloud.demo.annotation;

/**
 * @Author: Dely
 * @Date: 2019/12/8 21:35
 */

import java.lang.annotation.*;

/**
 * 注解容器
 */
@Retention(RetentionPolicy.RUNTIME)
@Inherited
@interface Bases {
    BaseAnnotation[] value();
}
