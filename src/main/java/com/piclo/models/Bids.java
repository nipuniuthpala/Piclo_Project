package com.piclo.models;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.math.BigDecimal;
import java.util.Date;

public class Bids {
    public String getId() {
        return id;
    }

    public String getCreated() {
        return created;
    }

    public Boolean getAccepted() {
        return accepted;
    }

    public String getCompetition() {
        return competition;
    }

    public String getSeller() {
        return seller;
    }

    public BigDecimal getValue() {
        return value;
    }

    public int getOfferedCapacity() {
        return offeredCapacity;
    }

    private String id;
    private String created;
    private Boolean accepted;
    private String competition;
    private String seller;
    private BigDecimal value;
    @JsonProperty("offered_capacity")
    private int offeredCapacity;
}
