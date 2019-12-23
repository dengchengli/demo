package springcloud.demo.uml;

/**
 * @Author: Dely
 * @Date: 2019/12/9 0:28
 */

public class Cat extends Animal implements Operation{
    private String name;
    private Dog dog;

    public Cat() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public void name() {
        System.out.println(name);
    }

    @Override
    public void move(String name) {
        System.out.println(String.format(name).concat(":move"));
    }
}
