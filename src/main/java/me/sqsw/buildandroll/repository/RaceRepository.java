package me.sqsw.buildandroll.repository;

import me.sqsw.buildandroll.model.Race;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface RaceRepository extends CrudRepository<Race, Integer> {
    List<Race> findByRaceIgnoreCase(String name);
    List<Race> findBySubraceIgnoreCase(String name);
    List<Race> findByRaceLikeIgnoreCaseOrSubraceLikeIgnoreCase(String race, String subrace);
}
