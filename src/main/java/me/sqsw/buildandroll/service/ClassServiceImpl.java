package me.sqsw.buildandroll.service;

import lombok.RequiredArgsConstructor;
import me.sqsw.buildandroll.model.CharacterClass;
import me.sqsw.buildandroll.repository.ClassRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ClassServiceImpl implements ClassService {
    private final ClassRepository repository;

    @Override
    public List<CharacterClass> getAll() {
        return repository.findAll();
    }
}
