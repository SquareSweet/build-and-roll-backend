package me.sqsw.buildandroll.service;

import lombok.RequiredArgsConstructor;
import me.sqsw.buildandroll.dto.SpellResponse;
import me.sqsw.buildandroll.dto.SpellsForClassResponse;
import me.sqsw.buildandroll.mapper.SpellMapper;
import me.sqsw.buildandroll.model.School;
import me.sqsw.buildandroll.model.Spell;
import me.sqsw.buildandroll.repository.SpellRepository;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class SpellServiceImpl implements SpellService {
    private final SpellRepository repository;
    private final SpellMapper mapper;

    @Override
    public List<SpellResponse> getAll() {
        return repository.findAll().stream().map(mapper::toDto).collect(Collectors.toList());
    }

    @Override
    public List<SpellsForClassResponse> getAllForClass(Integer classId) {
        return repository.findByCharacterClass_Id(classId)
                .stream().map(mapper::toDtoForClass).collect(Collectors.toList());
    }

    @Override
    public List<SpellResponse> getFiltered(Integer classId, Integer level, String school, String name, Integer page, Integer perPage) {
        String nameFilter = name == null ? null : "%" + name.toLowerCase() + "%";
        School schoolFilter = school == null ? null : School.valueOf(school);

        return repository.findFiltered(classId, level, schoolFilter, nameFilter, PageRequest.of(page, perPage))
                .stream().map(mapper::toDto).collect(Collectors.toList());
    }


}
