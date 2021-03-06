package io.muic.webapp.api.service;

import io.muic.webapp.api.entity.Achievement;
import io.muic.webapp.api.entity.User;
import io.muic.webapp.api.repository.AchievementRepository;
import io.muic.webapp.api.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Created by tyeon on 3/26/17.
 */
@Transactional
@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private AchievementRepository achievementRepository;

    public long count() {
        return userRepository.count();
    }

    public List<User> findAll() {
        return userRepository.findAll();
    }

    public User findOne(long id) {
        return userRepository.findOne(id);
    }

    public User save(User user) {
        return userRepository.save(user);
    }

    public Map login(String email, String password) {
        Map frb = new HashMap();
        User user = userRepository.findByEmail(email);
        boolean login = false;
        if (user != null) {
            if (user.getPassword().equals(password)) login = true;
        }
        frb.put("success", login);
        frb.put(User.SINGULAR, user);
        return frb;
    }

    public User create(String email, String password) {
        User user = new User();
        if (userRepository.findByEmail(email) == null) {
            user.setEmail(email);
            user.setPassword(password);
            user = save(user);
        }
        return user;
    }

    public boolean authenticate(String username, String password) {
        return true;
    }

    public User addAchievement(long id, Long achievementId) {
        User user = findOne(id);
        Achievement achievement = (achievementId != null) ? achievementRepository.findOne(achievementId) : null;
        if (achievement != null) {
            Set<Achievement> achievements = user.getAchievements();
            achievements.add(achievement);
            user.setAchievements(achievements);
            user = save(user);
        }
        return user;
    }

    public User updateScore(long id, Long score) {
        User user = findOne(id);
        long prevMax = user.getHighscore();
        if (score > prevMax) {
            user.setHighscore(score);
            user = save(user);
        }
        return user;
    }

    public List<User> getLeaderboard() {
        return userRepository.findTop10ByOrderByHighscoreDesc();
    }
}
