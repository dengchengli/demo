package springcloud.demo.interandclass;

/**
 * @Author: Dely
 * @Date: 2019/12/4 0:03
 */

/**
 * 接口性质测试
 *
 *   1.接口默认并且只能是public的访问权限。
 *   2.属性默认为final static类型的，并且缺省final static,即属性必须是不可修改的。
 *   3.方法可以是静态或指非静态方法。
 *   4.静态方法必须有方法体。
 *   5.非静态方法可以通过default修饰+方法体。
 */

public interface Special {
    //protected和private修饰符不能存在接口里边
    //protected String name ="11";
    //属性必须在定义是时初始化，属性可以是类属性或者是对象属性
    String name = "gggggggggggggggg";
    //static多余了
    static int id = 1;

    //静态方法必须要有方法体
    static void get(){
        System.out.println("get---------------"+name);
    }
    //
    void out();
    //default修饰符不能和static一起使用
    default void in(){
        System.out.println("in-----------------"+id);
    }
}
