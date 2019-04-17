package com.example.methotelsserver.services.impl;

import com.example.methotelsserver.model.Room;
import com.example.methotelsserver.repositories.RoomRepository;
import com.example.methotelsserver.services.RoomService;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class RoomServiceImpl implements RoomService {

    private RoomRepository roomRepository;

    public RoomServiceImpl(RoomRepository roomRepository) {
        this.roomRepository = roomRepository;
    }

    @Override
    public Set<Room> getAllRooms() {
        return roomRepository.findAll();
    }

    public Room addRoom(Room room){
        return roomRepository.save(room);
    }

    @Override
    public void deleteRoom(Long roomId) {
        Room room = roomRepository.getByRoomId(roomId);
        roomRepository.delete(room);
    }

    @Override
    public Room editRoom(Room newRoom, Long id) {

        Room room = roomRepository.getByRoomId(id);

        room.setBeds(newRoom.getBeds());
        room.setHasTV(newRoom.isHasTV());
        room.setHotelName(newRoom.getHotelName());
        room.setPrice(newRoom.getPrice());

        return roomRepository.save(room);
    }

    @Override
    public Room getRoom(Long id) {
        return roomRepository.getByRoomId(id);
    }


}
