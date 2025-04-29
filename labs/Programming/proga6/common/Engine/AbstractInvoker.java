package common.Engine;

import common.Commands.*;
import java.util.HashMap;
import java.util.Map;
/**
 * Абстрактный класс для Invoker, который хранит все команды
 * @author Alexander Sokolov
 * @version 1.0
 */
public abstract class AbstractInvoker {
    public Map<String, Command> commandz = new HashMap<>();

    /**Конструктор для автоматического добавления комманда в их пул */
    public AbstractInvoker(){
        this.commandz.put("add", new AddCommand());
        this.commandz.put("execute_script", new ExecuteScriptCommand());
        this.commandz.put("remove_first", new RemoveFirstCommand());
        //this.commandz.put("save", new SaveCommand());
        this.commandz.put("show", new ShowCommand());
        this.commandz.put("clear", new ClearCommand());
        this.commandz.put("remove_by_id", new RemoveByIdCommand());
        this.commandz.put("update", new UpdateIdCommand());
        this.commandz.put("insert_at", new InsertAtCommand());
        this.commandz.put("history", new HistoryCommand());
        this.commandz.put("max_by_meters_above_sea_level", new MaxByMetersAboveSeaLevel());
        this.commandz.put("filter_less_than_climate", new FilterLessThanClimate());
        this.commandz.put("print_ascending", new PrintAscendingCommand());
        this.commandz.put("info", new InfoCommand());
        this.commandz.put("help", new HelpCommand());
    }
}
