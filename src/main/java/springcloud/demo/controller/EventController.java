package springcloud.demo.controller;

/**
 * @Author: Dely
 * @Date: 2019/12/10 12:37
 */

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import springcloud.demo.eventdriver.UserService;

/**
 * 事件驱动controller
 */
@RestController
public class EventController {
    @Autowired
    private UserService userService;

    @GetMapping("/event/user")
    public ResponseEntity register(@RequestParam String name) {
        String res = null;
        try {
            res = userService.register(name);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ResponseEntity.ok(res);
    }
}
