package me.sqsw.buildandroll.service;

import me.sqsw.buildandroll.dto.RaceResponse;
import me.sqsw.buildandroll.model.Race;

import java.util.List;

public interface RaceService {
    List<RaceResponse> getAll();
    Race getById(Integer id);
}
