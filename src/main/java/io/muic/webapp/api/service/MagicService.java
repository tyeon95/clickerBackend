package io.muic.webapp.api.service;

import io.muic.webapp.api.entity.Magic;
import io.muic.webapp.api.repository.MagicRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

import java.util.List;

/**
 * Created by tyeon on 3/26/17.
 */
@Transactional
@Service
public class MagicService {
    @Autowired
    private MagicRepository magicRepository;

    public List<Magic> findAll() {
        return magicRepository.findAll();
    }

    public Magic findOne(long id) {
        return magicRepository.findOne(id);
    }

    private Magic save(Magic magic) {
        return magicRepository.save(magic);
    }

    public Magic create(String name, long damage, long cost) {
        Magic magic = new Magic();
        magic.setName(name);
        magic.setDamage(damage);
        magic.setCost(cost);
        return save(magic);
    }
}
