package springcloud.demo.eventdriver;

import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Service;

/**
 * @Author: Dely
 * @Date: 2019/12/10 12:23
 */

@Service
public class EmailService implements ApplicationListener<UserRegisterEvent> {
    @Override
    public void onApplicationEvent(UserRegisterEvent userRegisterEvent) {
        System.out.println("邮件服务已经接收到发送的通知，正在给"+userRegisterEvent.getSource()+"发送邮件！");
    }
}
