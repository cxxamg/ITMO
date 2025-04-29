package common.Entity;

import java.io.Serializable;

public class Human implements Serializable{
    private final String name; //Поле не может быть null, Строка не может быть пустой

    public Human(String name){
        this.name = name;
    }
    @Override
    public String toString() {
        return "Human{name=" + name + "}";
    }
    public String getName(){
        return this.name;
    }
}