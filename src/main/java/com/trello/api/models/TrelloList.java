package com.trello.api.models;


import java.util.List;

public class TrelloList {
    public String id;
    public String name;
    public boolean closed;
    List<Card> cards;
}
