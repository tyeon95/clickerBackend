package io.muic.webapp.controller;

import io.muic.webapp.api.entity.Game;
import io.muic.webapp.api.entity.User;
import io.muic.webapp.api.service.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by tyeon on 3/26/17.
 */
@CrossOrigin(origins = "*")
@RestController
@RequestMapping(value = "/"+ Game.PLURAL)
public class GameController {
    @Autowired
    private GameService gameService;

    @RequestMapping(value = {"/{id}/", "/{id}"}, method = RequestMethod.GET)
    public Map getActiveGameByUser(@PathVariable long id) {
        HashMap<String, Object> frb = new HashMap<>();
        frb.put(Game.SINGULAR, gameService.findActiveByUser(id));
        return frb;
    }

    @RequestMapping(value = {"/{id}/", "/{id}"}, method = RequestMethod.POST)
    public Map createGame(@PathVariable long id) {
        HashMap<String, Object> frb = new HashMap<>();
        frb.put(Game.SINGULAR, gameService.create(id));
        return frb;
    }

    @RequestMapping(value = {"/{id}/add_helper/{helperId}/", "/{id}/add_helper/{helperId}"}, method = RequestMethod.POST)
    public Map addHelper(@PathVariable long id, @PathVariable long helperId) {
        HashMap<String, Object> frb = new HashMap<>();
        frb.put(Game.SINGULAR, gameService.addHelper(id, helperId));
        return frb;
    }

    @RequestMapping(value = {"/{id}/use_magic/{magicId}/", "/{id}/use_magic/{magicId}"}, method = RequestMethod.POST)
    public Map addMagic(@PathVariable long id, @PathVariable long magicId) {
        HashMap<String, Object> frb = new HashMap<>();
        frb.put(Game.SINGULAR, gameService.useMagic(id, magicId));
        return frb;
    }

    @RequestMapping(value = {"/{id}/use_weapon/{weaponId}/", "/{id}/use_weapon/{weaponId}"}, method = RequestMethod.POST)
    public Map addWeapon(@PathVariable long id, @PathVariable long weaponId) {
        HashMap<String, Object> frb = new HashMap<>();
        frb.put(Game.SINGULAR, gameService.useWeapon(id, weaponId));
        return frb;
    }

    @RequestMapping(value = {"/{id}/stats/", "/{id}/stats"}, method = RequestMethod.GET)
    public Map getStats(@PathVariable long id) {
        HashMap<String, Object> frb = new HashMap<>();
        frb.put(Game.SINGULAR, gameService.getStats(id));
        return frb;
    }

    @RequestMapping(value = {"/{id}/archive/", "/{id}/archive"}, method = RequestMethod.POST)
    public void archiveGame(@PathVariable long id, @RequestParam(required = false) long score) {
        gameService.archive(id, score);
    }
}
