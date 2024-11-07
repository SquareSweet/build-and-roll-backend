package me.sqsw.buildandroll.mapper;

import me.sqsw.buildandroll.dto.WeaponResponse;
import me.sqsw.buildandroll.model.Weapon;
import org.springframework.stereotype.Component;

@Component
public class WeaponMapper {
    public WeaponResponse toDto(Weapon weapon) {
        return new WeaponResponse(weapon.getId(), weapon.getName(), weapon.getType(), weapon.getProperties());
    }
}
