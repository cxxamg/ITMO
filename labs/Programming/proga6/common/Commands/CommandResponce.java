package common.Commands;
import common.Entity.*;
import java.io.Serializable;

public class CommandResponce implements Serializable{
    public Command cmd;
    public String value;
    public CityImport city;
    public int typeOfCmdResponce;

    public CommandResponce(Command cmd, String value, CityImport city, int typeOfCmdResponce){
        this.cmd = cmd;
        this.value = value;
        this.city = city;
        this.typeOfCmdResponce = typeOfCmdResponce;
    }

    @Override
    public String toString(){
        return "CommandResponse{" +
               "cmd=" + (cmd != null ? cmd.getClass().getSimpleName() : "null") +
               ", value='" + value + '\'' +
               ", city=" + (city != null ? city.toString() : "null") +
               '}';
    }
}
