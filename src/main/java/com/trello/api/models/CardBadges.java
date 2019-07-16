package com.trello.api.models;

public class CardBadges {


    public int checkItems;
    public int comments;
    public int attachments;
    public boolean description;
    public String due;


    @Override
    public String toString() {
        return "badges{" +
                "checkItems='" + checkItems + '\'' +
                ", comments='" + comments + '\'' +
                ", attachments='" + attachments + '\'' +
                ", description='" + description + '\'' +
                ", due='" + due + '\'' +
                '}';
    }






}
