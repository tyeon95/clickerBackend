package io.muic.webapp.api.service;

import io.muic.webapp.api.entity.Helper;
import io.muic.webapp.api.repository.HelperRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

import java.util.List;

/**
 * Created by tyeon on 3/26/17.
 */
@Transactional
@Service
public class HelperService {
    @Autowired
    private HelperRepository helperRepository;

    public List<Helper> findAll() {
        return helperRepository.findAll();
    }

    public Helper findOne(long id) {
        return helperRepository.findOne(id);
    }

    private Helper save(Helper helper) {
        return helperRepository.save(helper);
    }

    public Helper create(String name, long damage, long cost) {
        Helper helper = new Helper();
        helper.setName(name);
        helper.setDamage(damage);
        helper.setCost(cost);
        return save(helper);
    }
}
