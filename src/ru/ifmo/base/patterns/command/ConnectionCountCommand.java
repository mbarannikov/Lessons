package ru.ifmo.base.patterns.command;

public class ConnectionCountCommand extends ServerCommand {
    public ConnectionCountCommand(Server server) {
        super(server);
    }

    @Override
    public void execute() {
        System.out.println(server + " отправит количество подключений " +
                server.getConnectionCount());
    }
}
