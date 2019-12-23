package springcloud.demo.interandclass;

/**
 * @Author: Dely
 * @Date: 2019/12/3 23:49
 */


/**
 * 抽象类特性的测试:
 * 1.属性可以是静态或指非静态属性，并且刻意不初始化。
 * 2.没有abstract字段修饰的方法，必须要有方法体。
 * 3.方法可以是静态或者非静态的方法。
 * 4.abstract 的方法不能和static或者private一起使用。
 * 5.子类可以访问和修改非private修饰的属性。
 * 6.因为抽象类主要是功能的封装，故而可以存在对属性进行修改，而接口是操作的封装，接口的就是规定属性是不可修改的。
 */
abstract public class Test {
    //可以为非静态属性会有默认初始化
    public String name = "good";
    //可以为静态属性会默认初始化
    private static int id = 2;

    //如果没有arbstract字段，则必须要有方法体。
    abstract public void get();
    //abstract不能喝static一起使用
    //abstract public static void out();

    public int getId() {
        return id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public static void setId(int id) {
        Test.id = id;
    }
}
