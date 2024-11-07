package me.sqsw.buildandroll.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CharacterShortResponse {
    Long id;
    String name;
    String race;
    @JsonProperty("class")
    String characterClass;
    Integer level;
}
