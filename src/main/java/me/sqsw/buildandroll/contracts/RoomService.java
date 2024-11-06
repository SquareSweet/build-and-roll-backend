package me.sqsw.buildandroll.contracts;

import me.sqsw.buildandroll.dto.response.RoomResponse;
import me.sqsw.buildandroll.model.Room;

import java.util.List;
import java.util.Optional;

public interface RoomService {
    Room create(String title);
    Optional<Room> getByTitle(String title);
    void addUserToRoom(Long userId, Long roomId) throws Exception;
    void removeUserFromRoom(Long userId, Long roomId) throws Exception;
    List<Room> getAll() throws Exception;

    Room getById(Long id);
}
