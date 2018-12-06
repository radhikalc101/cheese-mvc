package org.lanunchcode.cheesemvc.models;

public class Cheese {
    private String name;
    private String description;
    private int cheeseId;
    private static int nextId = 1;


    public Cheese(String name,String description){
        this();
        this.name = name;
        this.description = description;

    }

    public Cheese(){
        cheeseId = nextId;
        nextId++;
    }

    public void  setName(String name){
        this.name = name;
    }

    public String getName(){
        return this.name;
    }

    public void setDescription(String discription){
        this.description = discription;
    }

    public String getDescription(){
        return this.description;
    }
    public int getCheeseId() {
        return cheeseId;
    }

    public void setCheeseId(int cheeseId) {
        this.cheeseId = cheeseId;
    }
}


