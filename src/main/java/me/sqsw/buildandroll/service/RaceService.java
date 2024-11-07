package me.sqsw.buildandroll.service;

import me.sqsw.buildandroll.dto.RaceResponse;

import java.util.List;

public interface RaceService {
    List<RaceResponse> getAll();
}
