package org.lanunchcode.cheesemvc.models;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class Cheese {

    @NotNull
    @Size(min = 3, max = 8)
    private String name;

    @NotNull
    @Size(min = 1,message = "Enter the discription")
    private String description;

    private CheeseType type;


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

    public CheeseType getType() {
        return type;
    }

    public void setType(CheeseType type) {
        this.type = type;
    }
}


