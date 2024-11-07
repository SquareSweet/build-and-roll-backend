package me.sqsw.buildandroll.service;

import lombok.RequiredArgsConstructor;
import me.sqsw.buildandroll.dto.RaceResponse;
import me.sqsw.buildandroll.mapper.RaceMapper;
import me.sqsw.buildandroll.repository.RaceRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class RaceServiceImpl implements RaceService {
    private final RaceRepository repository;
    private final RaceMapper mapper;

    @Override
    public List<RaceResponse> getAll() {
        return repository.findAll().stream().map(mapper::toDto).collect(Collectors.toList());
    }
}
