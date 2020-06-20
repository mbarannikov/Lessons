package ru.ifmo.base.lesson19.messages;

import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Properties;

public class Server {
    private int port;
    private Connection connection;
    private Integer counter;

    public Server(int port){
        this.port = port;
        this.counter = 0;
    }

    public void plusCounter() {
        this.counter++;
    }

    public Integer getCounter() {
        return counter;
    }

    public  void start() throws IOException, ClassNotFoundException {
        try (ServerSocket serverSocket = new ServerSocket(port)){
            System.out.println("Сервер запущен... ");
            while (true){
                Socket clientSocket = serverSocket.accept();
                connection = new Connection(clientSocket);
                SimpleMessage mess = connection.readMessage();
                if (("/count").equalsIgnoreCase(mess.getText())) {
                    System.out.println("serverCount = " + getCounter());
                } else {
                    System.out.println(mess);
                }
                connection.sendMessage(SimpleMessage.getInstance("server","hello"));
                plusCounter();
            }

        }
    }

    public static void main(String[] args) {
        Properties properties = new Properties();
        try (
                InputStream input = Server.class
                        .getClassLoader()
                        .getResourceAsStream("example.properties")) {
            properties.load(input);
        }catch (IOException e){
            e.printStackTrace();
        }
        int port = Integer.parseInt(properties.getProperty("port","8090"));
        Server server = new Server(port);
        try {
            server.start();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
