package me.sqsw.buildandroll.service;

import lombok.RequiredArgsConstructor;
import me.sqsw.buildandroll.model.Spell;
import me.sqsw.buildandroll.repository.SpellRepository;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SpellServiceImpl implements SpellService {
    private final SpellRepository repository;

    @Override
    public List<Spell> getAll() {
        return repository.findAll();
    }

    @Override
    public List<Spell> getFiltered(Integer classId, Integer level, Integer page, Integer perPage) {
        if (level == null) {
            return repository.findByCharacterClass_Id(classId, PageRequest.of(page, perPage));
        } else {
            return repository.findByCharacterClass_IdAndLevelLessThanEqual(classId, level, PageRequest.of(page, perPage));
        }
    }


}
