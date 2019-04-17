package com.example.methotelsserver.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class Room implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long roomId;

    private String hotelName;

    private boolean hasTV;

    private int beds;

    private double price;

    @ManyToOne
    @JoinColumn(name = "userId")
    private User user;

    public Long getRoomId() {
        return roomId;
    }

    public void setRoomId(Long roomId) {
        this.roomId = roomId;
    }

    public String getHotelName() {
        return hotelName;
    }

    public void setHotelName(String hotelName) {
        this.hotelName = hotelName;
    }

    public boolean isHasTV() {
        return hasTV;
    }

    public void setHasTV(boolean hasTV) {
        this.hasTV = hasTV;
    }

    public int getBeds() {
        return beds;
    }

    public void setBeds(int beds) {
        this.beds = beds;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
