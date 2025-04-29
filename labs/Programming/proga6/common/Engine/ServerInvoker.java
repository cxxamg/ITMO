package common.Engine;

import common.Commands.ExitCommand;

public class ServerInvoker extends AbstractInvoker {

    public ServerInvoker(){
    super();
    this.commandz.put("exit", new ExitCommand());
}
}
