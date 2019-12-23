package disign.factorymodel;

/**
 * @Author: Dely
 * @Date: 2019/12/9 20:17
 */

/**
 * 工厂方法测试类
 */


public class FactoryModelTest {
    public static void main(String[] args) {
        Car moto = CarFactory.createCar("moto");
        Car baoMa = CarFactory.createCar("baoMa");
        moto.make();
        baoMa.make();
        Car other = CarFactory.createCar();
        other.make();
    }

}
