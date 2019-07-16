package com.trello.api.models;

public class Card {

    public String id;
    public String desc;
    public String idBoard;
    public String idList;
    public String name;
    public String url;
    public String[] idMembers;
    public String[] idLabels;
    public String[] idChecklists;
    public CardBadges badges;
    public String due;


    public Card(){}

    public Card(String name){
        this.name=name;
    }

    @Override
    public String toString() {
        return "Card{" +
                "id='" + id + '\'' +
                ", desc='" + desc + '\'' +
                ", idBoard='" + idBoard + '\'' +
                ", idList='" + idList + '\'' +
                ", name='" + name + '\'' +
                ", url='" + url + '\'' +
                ", idMembers= '" + idMembers + '\'' +
                ", idLabels= '" + idLabels + '\'' +
                ", idChecklists= '" + idChecklists + '\'' +
                ", badges= '" + badges + '\'' +
                ", due= '" + due + '\'' +
                '}';
    }
}
