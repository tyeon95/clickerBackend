package io.muic.webapp;

import io.muic.webapp.Initializers.AchievementInitializer;
import io.muic.webapp.Initializers.ItemInitializer;
import io.muic.webapp.Initializers.UserInitializer;
import io.muic.webapp.api.repository.HelperRepository;
import io.muic.webapp.api.repository.UserRepository;
import io.muic.webapp.api.service.HelperService;
import io.muic.webapp.api.service.MagicService;
import io.muic.webapp.api.service.UserService;
import io.muic.webapp.api.service.WeaponService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by tyeon on 3/26/17.
 */
@Component
public class ApplicationInitializer {
    private static final Logger logger = LoggerFactory.getLogger(ApplicationInitializer.class);

    @Autowired
    private UserService userService;
    @Autowired
    private ItemInitializer itemInitializer;
    @Autowired
    private UserInitializer userInitializer;
    @Autowired
    private AchievementInitializer achievementInitializer;

    public void populateDatabase() {
        long startTime = System.currentTimeMillis();

        if (userService.count() > 0) {
            logger.info("Application has been previously initialized.");
            return;
        }

        logger.info("Starting populateDatabase");

        userInitializer.populateDatabase();
        logger.info("userInitializer Done");

        achievementInitializer.populateDatabase();
        logger.info("achievementInitializer Done");

        itemInitializer.populateDatabase();
        logger.info("itemInitializer Done");

        long stopTime = System.currentTimeMillis();
        long elapsedTime = (stopTime - startTime) / 1000;
        logger.info("Application has been successfully initialized in " + elapsedTime + " s.");
    }
}
