package com.example.binuspark;

public class University {
    private String name = "BINUS";

    private String location;

    private int parkingSlot;

    public University(String location, int parkingSlot){
        this.location = location;

        this.parkingSlot = parkingSlot;
    }

    public String getName(){
        return this.name;
    }

    public String getLocation(){
        return this.location;
    }

    public int getParkingSlot(){
        return this.parkingSlot;
    }
}
