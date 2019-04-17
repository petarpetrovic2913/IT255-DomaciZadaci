package com.example.methotelsserver.controllers;

import com.example.methotelsserver.model.Room;
import com.example.methotelsserver.services.RoomService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Set;

@RestController
@RequestMapping("/rooms")
@CrossOrigin
public class RoomController {

    private RoomService roomService;

    public RoomController(RoomService roomService) {
        this.roomService = roomService;
    }

    @GetMapping("/all")
    @ResponseStatus(value = HttpStatus.OK)
    public Set<Room> getRooms(){
        return roomService.getAllRooms();
    }

    @PostMapping("/add")
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public Room addRoom(@Valid @RequestBody Room room){
        return roomService.addRoom(room);
    }


    @DeleteMapping("/delete/{id}")
    @ResponseStatus(value = HttpStatus.OK)
    public void deleteRoom(@PathVariable("id") Long id){
        roomService.deleteRoom(id);
    }

    @PutMapping("/edit/{id}")
    @ResponseStatus(value = HttpStatus.OK)
    public Room editProduct(@RequestBody Room room,@PathVariable("id") Long id){
        return roomService.editRoom(room,id);
    }

    @GetMapping("/{id}")
    @ResponseStatus(value = HttpStatus.OK)
    public Room editProduct(@PathVariable("id") Long id){
        return roomService.getRoom(id);
    }

}
