package ru.ifmo.base.patterns.command;

public class DefaultCommand extends ServerCommand{
    public DefaultCommand(Server server) {
        super(server);
    }

    @Override
    public void execute() {
        System.out.println(server + " отправит сообщение о том, что " +
                "команда не может быть обработана");
    }
}
