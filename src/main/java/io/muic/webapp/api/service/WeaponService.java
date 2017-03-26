package io.muic.webapp.api.service;

import io.muic.webapp.api.entity.Weapon;
import io.muic.webapp.api.repository.WeaponRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

import java.util.List;

/**
 * Created by tyeon on 3/26/17.
 */
@Transactional
@Service
public class WeaponService {
    @Autowired
    private WeaponRepository weaponRepository;

    public List<Weapon> findAll() {
        return weaponRepository.findAll();
    }

    public Weapon findOne(long id) {
        return weaponRepository.findOne(id);
    }

    private Weapon save(Weapon weapon) {
        return weaponRepository.save(weapon);
    }

    public Weapon create(String name, long damage, long cost) {
        Weapon weapon = new Weapon();
        weapon.setName(name);
        weapon.setDamage(damage);
        weapon.setCost(cost);
        return save(weapon);
    }
}
