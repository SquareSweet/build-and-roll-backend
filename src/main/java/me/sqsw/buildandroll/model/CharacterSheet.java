package me.sqsw.buildandroll.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;
import java.util.Set;

@Entity
@Getter
@Setter
@Table(name = "characters")
@EqualsAndHashCode(exclude = {"weapons", "spells", "characterStats, level"})
@AllArgsConstructor
@NoArgsConstructor
public class CharacterSheet {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
    private String name;
    private Integer level;
    @ManyToOne
    @JoinColumn(name = "race_id")
    private Race race;
    @ManyToOne
    @JoinColumn(name = "class_id")
    private CharacterClass characterClass;
    @OneToMany
    @JoinColumn(name = "character_id")
    private Set<CharacterStat> characterStats;
    @ManyToMany
    @JoinTable(
            name = "characters_spells",
            joinColumns = @JoinColumn(name = "character_id"),
            inverseJoinColumns = @JoinColumn(name = "spell_id")
    )
    private Set<Spell> spells;
    @ManyToMany
    @JoinTable(
            name = "characters_weapons",
            joinColumns = @JoinColumn(name = "char_id"),
            inverseJoinColumns = @JoinColumn(name = "weapons_id")
    )
    private List<Weapon> weapons;
}
