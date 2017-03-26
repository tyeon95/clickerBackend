package io.muic.webapp.api.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.Where;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by tyeon on 3/26/17.
 */
@Entity
@Where(clause = "is_active = 1")
public class Game {
    @Transient
    public static final String SINGULAR = "game";
    @Transient
    public static final String PLURAL = SINGULAR + "s";

    @Id
    @GeneratedValue
    private long id;

    private long score = 0;

    @OneToMany
    @JoinColumn(name = "helpers")
    private Set<Helper> helpers = new HashSet<>();

    private long helperDamage;

    @OneToMany
    @JoinColumn(name = "magics")
    private Set<Magic> magics = new HashSet<>();

    private long magicDamage;

    @OneToOne
    @JoinColumn(name = "weapon")
    private Weapon weapon;

    private long weaponDamage;

    private boolean isActive = true;

    @ManyToOne
    @JoinColumn(name = "users")
    private User user;

    public long getId() {
        return id;
    }

    public long getScore() {
        return score;
    }

    public void setScore(long score) {
        this.score = score;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    @JsonIgnore
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Set<Helper> getHelpers() {
        return helpers;
    }

    public void setHelpers(Set<Helper> helpers) {
        this.helpers = helpers;
    }

    public Set<Magic> getMagics() {
        return magics;
    }

    public void setMagics(Set<Magic> magics) {
        this.magics = magics;
    }

    public Weapon getWeapon() {
        return weapon;
    }

    public void setWeapon(Weapon weapon) {
        this.weapon = weapon;
    }

    public long getHelperDamage() {
        return helperDamage;
    }

    public void setHelperDamage(long helperDamage) {
        this.helperDamage = helperDamage;
    }

    public long getMagicDamage() {
        return magicDamage;
    }

    public void setMagicDamage(long magicDamage) {
        this.magicDamage = magicDamage;
    }

    public long getWeaponDamage() {
        return weaponDamage;
    }

    public void setWeaponDamage(long weaponDamage) {
        this.weaponDamage = weaponDamage;
    }
}
