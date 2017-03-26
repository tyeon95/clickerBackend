package io.muic.webapp.api.service;

import io.muic.webapp.api.entity.Achievement;
import io.muic.webapp.api.repository.AchievementRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by tyeon on 3/26/17.
 */
@Service
@Transactional
public class AchievementService {
    @Autowired
    private AchievementRepository achievementRepository;

    public List<Achievement> findAll() {
        return achievementRepository.findAll();
    }

    public Achievement findOne(long id) {
        return achievementRepository.findOne(id);
    }

    private Achievement save(Achievement achievement) {
        return achievementRepository.save(achievement);
    }

    public Achievement create(String name) {
        Achievement achievement = new Achievement();
        if (achievementRepository.findByName(name) != null) {
            achievement.setName(name);
            achievement = save(achievement);
        }
        return achievement;
    }
}
