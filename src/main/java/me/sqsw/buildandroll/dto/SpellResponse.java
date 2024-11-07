package me.sqsw.buildandroll.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import me.sqsw.buildandroll.model.CharacterClass;
import me.sqsw.buildandroll.model.School;

import java.util.Map;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class SpellResponse {
    private Integer id;
    private String name;
    private Integer level;
    private School school;
    private Set<CharacterClass> characterClass;
    private Map<String, Object> properties;
}
