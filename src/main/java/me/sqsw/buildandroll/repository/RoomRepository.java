package me.sqsw.buildandroll.repository;

import me.sqsw.buildandroll.model.Room;
import me.sqsw.buildandroll.model.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface RoomRepository extends CrudRepository<Room, Long> {
    Optional<Room> findByTitle(String title);

    List<Room> findByOwner(User user);
}