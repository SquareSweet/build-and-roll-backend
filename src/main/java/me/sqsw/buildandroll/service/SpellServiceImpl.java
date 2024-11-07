package me.sqsw.buildandroll.service;

import lombok.RequiredArgsConstructor;
import me.sqsw.buildandroll.model.School;
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
    public List<Spell> getFiltered(Integer classId, Integer level, String school, String name, Integer page, Integer perPage) {
        String nameFilter = name == null ? null : "%" + name.toLowerCase() + "%";
        School schoolFilter = school == null ? null : School.valueOf(school);

        return repository.findFiltered(classId, level, schoolFilter, nameFilter, PageRequest.of(page, perPage));
    }


}
