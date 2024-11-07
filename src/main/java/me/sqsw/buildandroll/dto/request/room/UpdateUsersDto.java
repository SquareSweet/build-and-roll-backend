package me.sqsw.buildandroll.dto.request.room;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import me.sqsw.buildandroll.dto.UserDto;
import me.sqsw.buildandroll.model.User;

import java.util.List;

@Getter
@Setter
@Data
public class UpdateUsersDto {
    private UserDto user;
    private List<UserDto> users;

}
