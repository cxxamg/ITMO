package Commands;
import Engine.Receiver;

public interface CollectionableCommand extends Command {
    Receiver receiver = new Receiver();
}


