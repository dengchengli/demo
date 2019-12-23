package springcloud.demo.service.juc;

/**
 * @Author: Dely
 * @Date: 2019/10/30 21:29
 */

import java.util.concurrent.ConcurrentHashMap;

/**
 * ConcurrentHashMap学习：
 *  1.
 */
public class Concurrent {
    public static void main(String[] args) {
        //
        outer:
        for (int i = 0; i < 3; i++) {
            System.out.println("我是"+i);
            for (int j = 0; j < 2; j++) {
                if (i==0) {
                    continue outer;
                }
                System.out.println("赶在我面前碗内色");
            }
        }
    }
}
