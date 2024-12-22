package Event;

public class InvalidCreatureHealthException extends RuntimeException{
    protected String message;
    public InvalidCreatureHealthException(String message){
        super(message);
        this.message = message;
    }
    @Override
    public String getMessage(){
        return message;
    }
}
