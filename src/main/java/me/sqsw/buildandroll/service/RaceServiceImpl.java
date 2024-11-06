package me.sqsw.buildandroll.service;

import lombok.RequiredArgsConstructor;
import me.sqsw.buildandroll.model.Race;
import me.sqsw.buildandroll.repository.RaceRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RaceServiceImpl implements RaceService {
    private final RaceRepository repository;

    @Override
    public List<Race> getAll() {
        return repository.findAll();
    }
}
