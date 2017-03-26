package io.muic.webapp.Initializers;

import io.muic.webapp.api.service.AchievementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by tyeon on 3/26/17.
 */
@Component
public class AchievementInitializer {
    @Autowired
    private AchievementService achievementService;

    public void populateDatabase() {
        achievementService.create("Get 500 points!");
        achievementService.create("Used Lightning!");
        achievementService.create("Bought 10 Helpers!");
    }
}
