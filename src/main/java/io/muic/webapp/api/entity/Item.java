package io.muic.webapp.api.entity;

import javax.persistence.MappedSuperclass;

/**
 * Created by tyeon on 3/26/17.
 */
@MappedSuperclass
public abstract class Item {

    private String name;

    private long damage;

    private long cost;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getDamage() {
        return damage;
    }

    public void setDamage(long damage) {
        this.damage = damage;
    }

    public long getCost() {
        return cost;
    }

    public void setCost(long cost) {
        this.cost = cost;
    }
}
