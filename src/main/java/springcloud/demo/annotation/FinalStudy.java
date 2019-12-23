package springcloud.demo.annotation;

import java.lang.annotation.Annotation;
import java.util.Arrays;

/**
 * @Author: Dely
 * @Date: 2019/12/8 21:33
 */

/**
 *如果子类添加了其他注解，父类的注解还是会被继承。与博客上说的，如果子类没其他注解的话就继承理解上有点出入。
 */

@InheritedAnnotation
public class FinalStudy extends AnnotationStudy {
    public static void main(String[] args) {
        boolean flag = FinalStudy.class.isAnnotationPresent(BaseAnnotation.class);
        System.out.println(flag);
        Annotation[] annotations = FinalStudy.class.getAnnotations();
        Arrays.asList(annotations).forEach(a-> System.out.println(a));
    }
}
