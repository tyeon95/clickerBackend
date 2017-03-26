package io.muic.webapp.controller;

import io.muic.webapp.api.entity.Game;
import io.muic.webapp.api.entity.Helper;
import io.muic.webapp.api.service.GameService;
import io.muic.webapp.api.service.HelperService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by tyeon on 3/26/17.
 */
@CrossOrigin(origins = "*")
@RestController
@RequestMapping(value = "/"+ Helper.PLURAL)
public class HelperController {
    @Autowired
    private HelperService helperService;

    @RequestMapping(value = {"/", ""}, method = RequestMethod.POST)
    public Map createHelper(@RequestParam(required = false) String name, @RequestParam(required = false) Long damage,
                            @RequestParam(required = false) Long cost) {
        HashMap<String, Object> frb = new HashMap<>();
        frb.put(Helper.SINGULAR, helperService.create(name, damage, cost));
        return frb;
    }
}
