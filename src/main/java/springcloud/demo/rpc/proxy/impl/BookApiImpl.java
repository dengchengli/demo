package springcloud.demo.rpc.proxy.impl;

import springcloud.demo.rpc.proxy.BookApi;

/**
 * @Author: Dely
 * @Date: 2019/11/27 23:23
 */
public class BookApiImpl implements BookApi {
    @Override
    public Object sell() {
        System.out.println("我是泼出去的水！");
        return "dddd";
    }
}
