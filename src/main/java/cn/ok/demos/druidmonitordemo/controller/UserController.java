package cn.ok.demos.druidmonitordemo.controller;

import cn.ok.demos.druidmonitordemo.entity.User;
import cn.ok.demos.druidmonitordemo.repository.UserRepository;
import cn.ok.demos.druidmonitordemo.server.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

/**
 * PROJECT_NAME: druid-monitor-demo
 * PACKAGE_NAME: cn.ok.demos.druidmonitordemo.controller
 *
 * @author kyou on 2018-12-05 15:08
 */
@Slf4j
@RestController
public class UserController {
    private final UserService userService;
    private final UserRepository userRepository;

    @Autowired
    public UserController(UserService userService, UserRepository userRepository) {
        this.userService = userService;
        this.userRepository = userRepository;
    }

    @GetMapping("/GetAllUser")
    String getAllUsers() {
        return userService.getAllUsers().toString();
    }

    @GetMapping("/AddUser/{cnt}")
    String addUsers(@PathVariable("cnt") int cnt) {

        for (int i = 1; i < cnt + 1; i++) {
            User user = new User();
            user.setPhone(13691463895L);
            user.setBirthDay(new Date());
            user.setAge(18 + i);
            user.setUserName("user" + i);
            userRepository.save(user);
        }

        return cnt + " User Added.";
    }
}
