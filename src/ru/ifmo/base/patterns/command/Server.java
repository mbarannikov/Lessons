package ru.ifmo.base.patterns.command;

import java.util.Random;

public class Server {

    private int connectionCount;

    public int getConnectionCount() {
        return connectionCount;
    }

    public void start(){
        while (true){
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            connectionCount++;
            String clientTask = genClientReq();
            executeCommand(ServerCommand.getCommand(clientTask,this));

        }
    }

    public void executeCommand(ServerCommand command){
        command.execute();
        // можно добавить сохранение выполненных команд в список
    }

    // вместо клиента
    public static String genClientReq(){
        String[] strings = {"time","connections","unknown_command","state"};
        Random random = new Random();
        return strings[random.nextInt(strings.length)];
    }

    public static void main(String[] args) {
        new Server().start();
    }
}
