package me.sqsw.buildandroll.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import me.sqsw.buildandroll.model.WeaponType;
import java.util.Map;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class WeaponResponse {
    private Integer id;
    private String name;
    private WeaponType type;
    private Map<String, Object> properties;
}
