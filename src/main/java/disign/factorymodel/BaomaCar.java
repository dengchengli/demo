package disign.factorymodel;

/**
 * @Author: Dely
 * @Date: 2019/12/9 20:47
 */
public class BaomaCar extends Car {
    @Override
    public void make(Object... args) {
        System.out.println("我是宝妈");
    }
}
