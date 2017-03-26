package io.muic.webapp.api.service;

import io.muic.webapp.api.entity.*;
import io.muic.webapp.api.repository.GameRepository;
import io.muic.webapp.api.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Created by tyeon on 3/26/17.
 */
@Service
@Transactional
public class GameService {
    @Autowired
    private GameRepository gameRepository;
    @Autowired
    private UserService userService;
    @Autowired
    private HelperService helperService;
    @Autowired
    private WeaponService weaponService;
    @Autowired
    private MagicService magicService;

    public List<Game> findAll() {
        return gameRepository.findAll();
    }

    public Game findOne(long id) {
        return gameRepository.findOne(id);
    }

    public Game findActiveByUser(long id) {
        User user = userService.findOne(id);
        return gameRepository.findByUser(user);
    }

    private Game save(Game game) {
        return gameRepository.save(game);
    }

    public Game create(long id) {
        Game game = new Game();
        User user = userService.findOne(id);
        game.setUser(user);

        Set<Game> games = user.getGames();
        games.add(game);
        user.setGames(games);
        return save(game);
    }

    public long addHelper(long id, long helperId) {
        Game game = findOne(id);
        Set<Helper> helpers = game.getHelpers();
        Helper helper = helperService.findOne(helperId);
        helpers.add(helper);
        game.setHelpers(helpers);
        game.setHelperDamage(game.getHelperDamage() + helper.getDamage());
        save(game);
        return game.getHelperDamage();
    }

    public long useMagic(long id, long magicId) {
        Game game = findOne(id);
        Set<Magic> magics = game.getMagics();
        Magic magic = magicService.findOne(magicId);
        magics.add(magic);
        game.setMagics(magics);
        game.setMagicDamage(game.getHelperDamage() + magic.getDamage());
        save(game);
        return game.getMagicDamage();
    }

    public long useWeapon(long id, long weaponId) {
        Game game = findOne(id);
        Weapon weapon = weaponService.findOne(weaponId);
        game.setWeapon(weapon);
        game.setWeaponDamage(weapon.getDamage());
        save(game);
        return game.getWeaponDamage();
    }

    public void archive(long id, long score) {
        Game game = findOne(id);
        if (game != null) {
            game.setScore(score);
            userService.updateScore(game.getUser().getId(), game.getScore());
            game.setActive(false);
            save(game);
        }
    }

    public Map getStats(long id) {
        Game game = findOne(id);
        Map<String, Number> stats = new HashMap<>();
        if (game != null) {

            stats.put("helpers", game.getHelpers().size());
            stats.put("helpersDamage", game.getHelperDamage());

            stats.put("magics", game.getMagics().size());
            stats.put("magicsDamage", game.getMagicDamage());

            stats.put("weaponDamage", game.getWeaponDamage());
        }
        return stats;
    }
}
