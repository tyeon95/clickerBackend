package io.muic.webapp.Initializers;

import io.muic.webapp.api.entity.User;
import io.muic.webapp.api.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by tyeon on 3/26/17.
 */
@Component
public class UserInitializer {
    @Autowired
    private UserService userService;

    public void populateDatabase() {
        User user = userService.create("wony_95@hotmail.com", "1234");
        user.setHighscore(200L);
        userService.save(user);
        user = userService.create("test@test.com", "1234");
        user.setHighscore(180L);
        userService.save(user);
        user = userService.create("pwnage@gmail.com", "1234");
        user.setHighscore(150L);
        userService.save(user);
        user = userService.create("bossy@hotmail.com", "1234");
        user.setHighscore(120L);
        userService.save(user);
        user = userService.create("ttt@hotmail.com", "1234");
        user.setHighscore(100L);
        userService.save(user);
        user = userService.create("asg@hotmail.com", "1234");
        user.setHighscore(80L);
        userService.save(user);
        user = userService.create("johnny@hotmail.com", "1234");
        user.setHighscore(40L);
        userService.save(user);
        user = userService.create("majeed@hotmail.com", "1234");
        user.setHighscore(30L);
        userService.save(user);
        user = userService.create("nok@hotmail.com", "1234");
        user.setHighscore(20L);
        userService.save(user);
        user = userService.create("noob@gmail.com", "1234");
        user.setHighscore(10L);
        userService.save(user);

    }
}
