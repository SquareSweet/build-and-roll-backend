package me.sqsw.buildandroll.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import me.sqsw.buildandroll.model.User;

@Getter
@Setter
@AllArgsConstructor
public class UserDto {

    private Long id;
    private String username;
    
    public UserDto(User user) {
        this.id = user.getId();
        this.username = user.getUsername();
    }
}