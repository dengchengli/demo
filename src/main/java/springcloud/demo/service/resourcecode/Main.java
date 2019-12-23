package springcloud.demo.service.resourcecode;

import springcloud.demo.service.TestService;
import springcloud.demo.service.TestServiceImpl;

/**
 * @Author: Dely
 * @Date: 2019/10/25 21:14
 */
public class Main {
    public static void main(String[] args) {
        TestService service = new TestServiceImpl();
        service.getValue();

    }
}
