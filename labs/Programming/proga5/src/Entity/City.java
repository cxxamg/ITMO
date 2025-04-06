package Entity;

import java.time.LocalDate;

public class City {
    private Long id; //Поле не может быть null, Значение поля должно быть больше 0, Значение этого поля должно быть уникальным, Значение этого поля должно генерироваться автоматически
    private final String name; //Поле не может быть null, Строка не может быть пустой
    private final Coordinates coordinates; //Поле не может быть null
    private final java.time.LocalDate creationDate; //Поле не может быть null, Значение этого поля должно генерироваться автоматически
    private final Float area; //Значение поля должно быть больше 0, Поле не может быть null
    private final Integer population; //Значение поля должно быть больше 0, Поле не может быть null
    private final Integer metersAboveSeaLevel;
    private final Climate climate; //Поле не может быть null
    private final Government government; //Поле может быть null
    private final StandardOfLiving standardOfLiving; //Поле не может быть null
    private final Human governor; //Поле может быть null

    public City(Long id, String name, Coordinates coordinates, java.time.LocalDate creationDate, Float area, Integer population,
    Integer metersAboveSeaLevel, Climate climate, Government government, StandardOfLiving standardOfLiving, Human governor){
        this.id = id;
        this.name = name;
        this.coordinates = coordinates;
        this.creationDate = creationDate;
        this.area = area;
        this.population = population;
        this.metersAboveSeaLevel = metersAboveSeaLevel;
        this.climate = climate;
        this.government = government;
        this.standardOfLiving = standardOfLiving;
        this.governor = governor;
    }
    @Override
    public String toString() {
        return "City{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", coordinates=" + coordinates +  
                ", creationDate=" + creationDate +
                ", area=" + area +
                ", population=" + population +
                ", metersAboveSeaLevel=" + metersAboveSeaLevel +
                ", climate=" + climate +
                ", government=" + government +
                ", standardOfLiving=" + standardOfLiving +
                ", governor=" + governor +  
                '}';
    }

    public long getId(){
        return this.id;
    }
    public void setId(long id){
        this.id = id;
    }
    public String getName(){
        return this.name;
    }
    public Coordinates getCoordinates(){
        return this.coordinates;
    }
    public LocalDate getCreationDate(){
        return this.creationDate;
    }
    public float getArea(){
        return this.area;
    }
    public int getPopulation(){
        return this.population;
    }
    public int getMetersAboveSeaLevel(){
        return this.metersAboveSeaLevel;
    }
    public Climate getClimate(){
        return this.climate;
    }
    public Government getGovernment(){
        return this.government;
    }
    public StandardOfLiving getStandardOfLiving(){
        return this.standardOfLiving;
    }
    public Human getHuman(){
        return this.governor;
    }
}

