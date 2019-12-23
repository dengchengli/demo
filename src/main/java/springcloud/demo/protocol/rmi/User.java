package springcloud.demo.protocol.rmi;

/**
 * @Author: Dely
 * @Date: 2019/12/2 17:10
 */

/**
 * 实体类
 */
public class User {
    private int id;
    private String name;

    public User(int id, String name) {
        this.id = id;
        this.name = name;
    }
}
