package me.sqsw.buildandroll.dto.request.room;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class UserJoinToRoomRequest {

    private Long userId;
    private Long roomId;
    private Long characterListId;

}