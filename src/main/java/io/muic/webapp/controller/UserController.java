package io.muic.webapp.controller;

import io.muic.webapp.api.entity.User;
import io.muic.webapp.api.service.UserService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by tyeon on 3/26/17.
 */
@CrossOrigin(origins = "*")
@RestController
@RequestMapping(value = "/"+ User.PLURAL)
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping(value = {"/", ""}, method = RequestMethod.GET)
    public Map getUsers() {
        HashMap<String, Object> frb = new HashMap<>();
        List<User> users = userService.findAll();
        frb.put(User.PLURAL, users);
        return frb;
    }

    @RequestMapping(value = {"/{id}/", "/{id}"}, method = RequestMethod.GET)
    public Map getUser(@PathVariable long id) {
        HashMap<String, Object> frb = new HashMap<>();
        frb.put(User.SINGULAR, userService.findOne(id));
        return frb;
    }

    @RequestMapping(value = {"/login/", "/login"}, method = RequestMethod.POST)
    public Map getUser(@RequestParam(required = false) String email, @RequestParam(required = false) String password) {
        return userService.login(email, password);
    }

    @RequestMapping(value = {"/", ""}, method = RequestMethod.POST)
    public Map createUser(@RequestParam(required = false) String email, @RequestParam(required = false) String password) {
        System.out.println(email);
        System.out.println(password);
        HashMap<String, Object> frb = new HashMap<>();
        User user = userService.create(email, password);
        frb.put(User.SINGULAR, user);
        return frb;
    }

    @RequestMapping(value = {"/{id}/add_achievement/{achievement}/", "/{id}/add_achievement/{achievement}"}, method = RequestMethod.POST)
    public Map addAchievement(@PathVariable long id, @PathVariable long achievement) {
        HashMap<String, Object> frb = new HashMap<>();
        User user = userService.addAchievement(id, achievement);
        frb.put(User.SINGULAR, user);
        return frb;
    }

    @RequestMapping(value = {"/leaderboards/", "/leaderboards"}, method = RequestMethod.GET)
    public Map getLeaderboard() {
        HashMap<String, Object> frb = new HashMap<>();
        frb.put(User.SINGULAR, userService.getLeaderboard());
        return frb;
    }
}
