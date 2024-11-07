package me.sqsw.buildandroll.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import me.sqsw.buildandroll.model.CharacterStat;

import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CharacterCreateRequest {
    String name;
    Integer raceId;
    Integer classId;
    Set<StatRequest> stats;
    Set<Integer> spells;
}
