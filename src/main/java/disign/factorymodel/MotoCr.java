package disign.factorymodel;

/**
 * @Author: Dely
 * @Date: 2019/12/9 20:45
 */

public class MotoCr extends Car{
    @Override
    public void make(Object... args) {
        System.out.println("我是摩托车");
    }
}
