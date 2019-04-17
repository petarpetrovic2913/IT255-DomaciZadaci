package com.example.methotelsserver.services;

import com.example.methotelsserver.model.Room;

import java.util.Set;

public interface RoomService {
    Set<Room> getAllRooms();
    Room addRoom(Room room);
    void deleteRoom(Long roomId);
    Room editRoom(Room newRoom,Long id);
    Room getRoom(Long id);
}
