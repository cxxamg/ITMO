package Engine;

import Commands.*;
import java.util.HashMap;
import java.util.Map;

public abstract class AbstractInvoker {
    public Map<String, Command> commandz = new HashMap<>();

    public AbstractInvoker(){
        this.commandz.put("add", new AddCommand());
        this.commandz.put("execute_script", new ExecuteScriptCommand());
        this.commandz.put("remove_first", new RemoveFirstCommand());
        this.commandz.put("save", new SaveCommand());
        this.commandz.put("show", new ShowCommand());
        this.commandz.put("clear", new ClearCommand());
        this.commandz.put("remove_by_id", new RemoveByIdCommand());
        this.commandz.put("update", new UpdateIdCommand());
        this.commandz.put("insert_at", new InsertAtCommand());
        this.commandz.put("history", new HistoryCommand());
    }
}
