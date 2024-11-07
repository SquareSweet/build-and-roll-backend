package me.sqsw.buildandroll.service;

import me.sqsw.buildandroll.dto.WeaponResponse;
import me.sqsw.buildandroll.model.Weapon;

import java.util.List;

public interface WeaponService {
    List<WeaponResponse> getAll();
    List<WeaponResponse> getFiltered(String type, String name, Integer page, Integer pageSize);
}
