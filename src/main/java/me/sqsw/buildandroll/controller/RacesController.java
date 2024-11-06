package me.sqsw.buildandroll.controller;

import lombok.RequiredArgsConstructor;
import me.sqsw.buildandroll.model.Race;
import me.sqsw.buildandroll.service.RaceService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/lib/race")
@RequiredArgsConstructor
public class RacesController {
    private final RaceService raceService;

    @GetMapping("/all")
    public List<Race> getAll() {
        return raceService.getAll();
    }
}
