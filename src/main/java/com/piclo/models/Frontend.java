package com.piclo.models;



public class Frontend {
    private String competition_id;

    public void setCompetition_id(String competition_id) {
        this.competition_id = competition_id;
    }

    public void setSeller(String seller) {
        this.seller = seller;
    }

    public void setBuyer(String buyer) {
        Buyer = buyer;
    }

    public void setBid_count(String bid_count) {
        Bid_count = bid_count;
    }

    private String seller;
    private String Buyer;
    private String Bid_count;

    public String getCompetition_id() {
        return competition_id;
    }

    public String getSeller() {
        return seller;
    }
    public String getBuyer() {
        return Buyer;
    }

    public String getBidCount() {
        return Bid_count;
    }

}
