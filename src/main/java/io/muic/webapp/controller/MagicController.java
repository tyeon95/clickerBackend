package io.muic.webapp.controller;

import io.muic.webapp.api.entity.Magic;
import io.muic.webapp.api.service.MagicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by tyeon on 3/26/17.
 */
@RestController
@RequestMapping(value = "/"+ Magic.PLURAL)
public class MagicController {
    @Autowired
    private MagicService magicService;

    @RequestMapping(value = {"/", ""}, method = RequestMethod.POST)
    public Map createMagic(@RequestParam(required = false) String name, @RequestParam(required = false) Long damage,
                            @RequestParam(required = false) Long cost) {
        HashMap<String, Object> frb = new HashMap<>();
        frb.put(Magic.SINGULAR, magicService.create(name, damage, cost));
        return frb;
    }
}

