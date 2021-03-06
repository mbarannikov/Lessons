package ru.ifmo.base.patterns.command;

import java.time.LocalTime;

public class TimeCommand extends ServerCommand {
    public TimeCommand(Server server) {
        super(server);
    }

    @Override
    public void execute() {
        System.out.println(server + " вернет время " + LocalTime.now());
    }
}
