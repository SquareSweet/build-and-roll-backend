package me.sqsw.buildandroll.service;

import lombok.RequiredArgsConstructor;
import me.sqsw.buildandroll.dto.CharacterClassResponse;
import me.sqsw.buildandroll.mapper.CharacterClassMapper;
import me.sqsw.buildandroll.repository.ClassRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ClassServiceImpl implements ClassService {
    private final ClassRepository repository;
    private final CharacterClassMapper mapper;

    @Override
    public List<CharacterClassResponse> getAll() {
        return repository.findAll().stream().map(mapper::toDto).collect(Collectors.toList());
    }
}
