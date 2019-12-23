package springcloud.demo.annotation;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * @Author: Dely
 * @Date: 2019/12/8 21:11
 */


/**
 *
 */
@InheritedAnnotation
@Retention(RetentionPolicy.RUNTIME)
public @interface ChildAnnotation {
}
