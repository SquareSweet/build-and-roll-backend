package me.sqsw.buildandroll.service;

import me.sqsw.buildandroll.model.Weapon;

import java.util.List;

public interface WeaponService {
    List<Weapon> getAll();
    List<Weapon> getFiltered(String type, String name, Integer page, Integer pageSize);
}
