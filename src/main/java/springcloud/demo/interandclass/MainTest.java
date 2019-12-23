package springcloud.demo.interandclass;

import springcloud.demo.interandclass.impl.SpecialImpl;
import springcloud.demo.interandclass.impl.TestImpl;

/**
 * @Author: Dely
 * @Date: 2019/12/4 0:14
 */


public class MainTest {
    public static void main(String[] args) {
        Test test = new TestImpl();

        System.out.println(test.name);
        test.get();
        System.out.println(test.getId());

        Special special= new SpecialImpl();
        special.in();
        special.out();
        Special.get();
    }
}
