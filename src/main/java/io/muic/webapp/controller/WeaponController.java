package io.muic.webapp.controller;

import io.muic.webapp.api.entity.Weapon;
import io.muic.webapp.api.service.WeaponService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by tyeon on 3/26/17.
 */
@CrossOrigin(origins = "*")
@RestController
@RequestMapping(value = "/"+ Weapon.PLURAL)
public class WeaponController {
    @Autowired
    private WeaponService weaponService;

    @RequestMapping(value = {"/", ""}, method = RequestMethod.POST)
    public Map createWeapon(@RequestParam(required = false) String name, @RequestParam(required = false) Long damage,
                           @RequestParam(required = false) Long cost) {
        HashMap<String, Object> frb = new HashMap<>();
        frb.put(Weapon.SINGULAR, weaponService.create(name, damage, cost));
        return frb;
    }
}
