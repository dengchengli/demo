package springcloud.demo.annotation;

/**
 * @Author: Dely
 * @Date: 2019/12/8 19:12
 */


import java.lang.annotation.Annotation;

/**
 * Java注解复习：
 * 注解主要目标是用来标志和解释代码。
 */

@BaseAnnotation
public class AnnotationStudy {

    String value;
    public static void main(String[] args) {
        boolean flag = AnnotationStudy.class.isAnnotationPresent(BaseAnnotation.class);
        if (flag){
            Annotation[] annotations = AnnotationStudy.class.getAnnotations();
            for (Annotation a : annotations) {
                System.out.println(a);
                BaseAnnotation baseAnnotation = (BaseAnnotation) a;
                System.out.println(baseAnnotation.id());
            }
        }
        System.out.println(flag);
    }


}
