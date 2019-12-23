package springcloud.demo.interandclass.impl;

import springcloud.demo.interandclass.Test;

/**
 * @Author: Dely
 * @Date: 2019/12/4 0:15
 */
public class TestImpl extends Test {
    @Override
    public void get() {
        super.setName("gggg");
        System.out.println(super.name);
    }
}
