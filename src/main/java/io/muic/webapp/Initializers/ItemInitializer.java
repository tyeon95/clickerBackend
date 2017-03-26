package io.muic.webapp.Initializers;

import io.muic.webapp.api.service.HelperService;
import io.muic.webapp.api.service.MagicService;
import io.muic.webapp.api.service.WeaponService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by tyeon on 3/26/17.
 */
@Component
public class ItemInitializer {
    @Autowired
    private HelperService helperService;
    @Autowired
    private WeaponService weaponService;
    @Autowired
    private MagicService magicService;

    public void populateDatabase() {
        helperService.create("circle", 2, 5);
        helperService.create("square", 5, 10);
        helperService.create("triangle", 15, 20);

        weaponService.create("rock", 2, 50);
        weaponService.create("wrench", 5, 100);
        weaponService.create("katana", 20, 500);

        magicService.create("fire", 50, 50);
        magicService.create("lightning", 100, 100);
        magicService.create("hail", 200, 200);
    }
}
