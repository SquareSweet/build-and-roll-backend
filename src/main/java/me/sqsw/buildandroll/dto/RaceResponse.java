package me.sqsw.buildandroll.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Map;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class RaceResponse {
    private Integer id;
    private String name;
    private Map<String, Object> properties;
}
