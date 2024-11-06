package me.sqsw.buildandroll.model;

import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

import java.util.Map;
import java.util.Set;

@Entity
@Getter
@Setter
@Table(name = "spells")
@EqualsAndHashCode
public class Spell {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private Integer level;
    @ManyToMany
    @JoinTable(
            name = "classes_spells",
            joinColumns = @JoinColumn(name = "class_id"),
            inverseJoinColumns = @JoinColumn(name = "spell_id")
    )
    private Set<CharacterClass> characterClass;
    @Enumerated(EnumType.STRING)
    private School school;
    @JdbcTypeCode(SqlTypes.JSON)
    private Map<String, Object> properties;
}
