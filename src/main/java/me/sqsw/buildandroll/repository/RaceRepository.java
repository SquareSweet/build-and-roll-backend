package me.sqsw.buildandroll.repository;

import me.sqsw.buildandroll.model.Race;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface RaceRepository extends CrudRepository<Race, Integer> {
    List<Race> findAll();
}
