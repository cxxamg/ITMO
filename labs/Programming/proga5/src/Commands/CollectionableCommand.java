package Commands;
import Engine.Receiver;
/**
 * Интерфейс для команд, работающих с коллекцией
 * @author Alexander Sokolov
 * @version 1.0
 */
public interface CollectionableCommand extends Command {
    Receiver receiver = new Receiver();
}


