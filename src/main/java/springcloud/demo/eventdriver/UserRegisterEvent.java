package springcloud.demo.eventdriver;

/**
 * @Author: Dely
 * @Date: 2019/12/10 12:09
 */

import org.springframework.context.ApplicationEvent;

/**
 *定义用户注册事件
 */

//该事件对象不需要交由spring容器来管理
public class UserRegisterEvent extends ApplicationEvent {
    /**
     *
     * @param source 事件对象
     */
    public UserRegisterEvent(Object source) {
        super(source);
    }
}
