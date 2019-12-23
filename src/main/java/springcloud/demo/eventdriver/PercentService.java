package springcloud.demo.eventdriver;

import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Service;

/**
 * @Author: Dely
 * @Date: 2019/12/10 12:27
 */

/**
 * 定义积分服务
 */
@Service
public class PercentService implements ApplicationListener<UserRegisterEvent> {
    @Override
    public void onApplicationEvent(UserRegisterEvent userRegisterEvent) {
        System.out.println(String.format("积分服务已经接受到增加积分的通知，正在给%s增加积分....", userRegisterEvent.getSource()));
    }
}
