package me.sqsw.buildandroll.model;

import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

import java.util.Map;

@Entity
@Getter
@Setter
@Table(name = "races")
@EqualsAndHashCode
public class Race {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String race;
    private String subrace;
    @JdbcTypeCode(SqlTypes.JSON)
    private Map<String, Object> properties;
}