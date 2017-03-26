package io.muic.webapp.controller;

import io.muic.webapp.api.entity.Achievement;
import io.muic.webapp.api.service.AchievementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by tyeon on 3/26/17.
 */
@RestController
@RequestMapping(value = "/"+ Achievement.PLURAL)
public class AchievementController {
    @Autowired
    private AchievementService achievementService;

    @RequestMapping(value = {"/", ""}, method = RequestMethod.GET)
    public Map getAchievements() {
        HashMap<String, Object> frb = new HashMap<>();
        List<Achievement> achievements = achievementService.findAll();
        frb.put(Achievement.PLURAL, achievements);
        return frb;
    }
}
