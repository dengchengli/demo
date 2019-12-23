package disign.factorymodel;

/**
 * @Author: Dely
 * @Date: 2019/12/9 20:48
 */

import org.springframework.util.Assert;

/**
 * 简单工厂类
 */
public class CarFactory {
    public static Car createCar(String... args){
        Assert.notNull(args,"所需要创建的对象类型不能为null");
        switch (args[0]) {
            case "moto": return new MotoCr();
            case "baoMa": return new BaomaCar();
        }
        throw new IllegalArgumentException(String.format("本简单工厂不能创建%s类型的对象", args[0]));
    }
}
