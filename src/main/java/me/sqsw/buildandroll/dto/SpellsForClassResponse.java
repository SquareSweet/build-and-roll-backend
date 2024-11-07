package me.sqsw.buildandroll.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import me.sqsw.buildandroll.model.School;

import java.util.Map;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class SpellsForClassResponse {
    private Integer id;
    private String name;
    private Integer level;
    private School school;
    private Map<String, Object> properties;
}
