package me.sqsw.buildandroll.mapper;

import me.sqsw.buildandroll.dto.RaceResponse;
import me.sqsw.buildandroll.model.Race;
import org.springframework.stereotype.Component;

@Component
public class RaceMapper {
    public RaceResponse toDto(Race race) {
        return new RaceResponse(race.getId(), race.getName(), race.getProperties());
    }
}
