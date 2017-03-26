package io.muic.webapp.Initializers;

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
        userService.create("wony_95@hotmail.com", "1234");
    }
}
