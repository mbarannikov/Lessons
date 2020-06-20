package ru.ifmo.base.patterns.command;

abstract public class ServerCommand {
    protected Server server;

    public ServerCommand(Server server){
        this.server = server;
    }

//    должен быть реализован каждой конкретной командой
    abstract public void execute();

    // фабричный метод
    public static ServerCommand getCommand(String type, Server server){
     //   Class cls = Class.forName(type);
        ServerCommand command = new DefaultCommand(server);
        if("time".equalsIgnoreCase(type)){
            command = new TimeCommand(server);
        } else if("connection".equalsIgnoreCase(type)){
            command = new ConnectionCountCommand(server);
        }
        return command;
    }
}
