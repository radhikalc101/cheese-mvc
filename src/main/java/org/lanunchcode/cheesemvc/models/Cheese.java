package org.lanunchcode.cheesemvc.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class Cheese {

    @Id
    @GeneratedValue
    private int id;

    @NotNull
    @Size(min = 3, max = 8)
    private String name;

    @NotNull
    @Size(min = 1,message = "Enter the discription")
    private String description;

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    @ManyToOne
    private Category category;


    public Cheese(String name,String description,Category category){
        this.name = name;
        this.description = description;
        this.category = category;
    }

    public Cheese(){ }

    public int getId(){
        return id;
    }

    public void setId(int id){ this.id = id;

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


}


