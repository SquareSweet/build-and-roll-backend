package me.sqsw.buildandroll.service;

import me.sqsw.buildandroll.model.Weapon;

import java.util.List;

public interface WeaponService {
    List<Weapon> getAll(Integer page, Integer pageSize);
    List<Weapon> getByType(String type, Integer page, Integer pageSize);
}
