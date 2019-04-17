package com.example.methotelsserver.repositories;

import com.example.methotelsserver.model.Room;

import org.springframework.data.repository.CrudRepository;

import java.util.Set;

public interface RoomRepository extends CrudRepository<Room, Long> {
    Set<Room> findAll();
    Room getByRoomId(Long id);
}
