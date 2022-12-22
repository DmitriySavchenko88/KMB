package com.aimporsoft.api;

public class PetsData {
    private final Integer id;
    private final String name;

    private final String status;


    public PetsData(Integer id, String name, String status) {
        this.id = id;
        this.name = name;
        this.status = status;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getStatus() {
        return status;
    }
}