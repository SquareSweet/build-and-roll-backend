package me.sqsw.buildandroll.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import me.sqsw.buildandroll.model.User;

@Getter
@Setter
@AllArgsConstructor
public class UserDto {

    private String username;
    
    public UserDto(User user) {
        this.username = user.getUsername();
    }
}