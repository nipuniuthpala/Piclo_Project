package com.piclo.models;



public class Competitions {
    public String getId() {
        return id;
    }

    public String getBuyer() {
        return buyer;
    }

    public String getName() {
        return name;
    }

    public String getOpen() {
        return open;
    }

    public String getClosed() {
        return closed;
    }

    public int getMinimum_capacity() {
        return minimum_capacity;
    }

    public String getCurrency() {
        return currency;
    }

    private String id;
    private String buyer;
    private String name;
    private String open;
    private String closed;
    private int minimum_capacity;
    private String currency;
}
