package me.sqsw.buildandroll.dto;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import me.sqsw.buildandroll.model.*;

import java.util.List;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CharacterFullResponse {
    private Long id;
    private String name;
    private Integer level;
    private RaceResponse race;
    private CharacterClassResponse characterClass;
    private Set<StatResponse> characterStats;
    private Set<SpellResponse> spells;
    private List<WeaponResponse> weapons;
}
