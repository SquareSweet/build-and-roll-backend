package me.sqsw.buildandroll.contracts;

import me.sqsw.buildandroll.dto.UserDto;
import me.sqsw.buildandroll.dto.request.room.UpdateUsersDto;
import me.sqsw.buildandroll.dto.response.RoomResponse;
import me.sqsw.buildandroll.model.Room;

import java.util.List;
import java.util.Optional;

public interface RoomService {
    Room create(String title);
    Optional<Room> getByTitle(String title);
    void addUserToRoom(Long userId, Long roomId) throws Exception;
    void removeUserFromRoom(Long userId, Long roomId) throws Exception;
    void sendAllUsersInRoom(Long roomId, UpdateUsersDto users);
    List<Room> getAllOwned() throws Exception;
    List<Room> getAll() throws Exception;
    Room getById(Long id);
}
