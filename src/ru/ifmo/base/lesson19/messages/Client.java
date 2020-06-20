package ru.ifmo.base.lesson19.messages;

import java.io.IOException;
import java.io.InputStream;
import java.net.ConnectException;
import java.net.Socket;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.Arrays;
import java.util.Properties;
import java.util.Scanner;

public class Client {
    private int port;
    private String ip;
    private Scanner scanner;
    private LocalDateTime StartTime;
    private LocalDateTime EndTime;
    private static String [] commands = new String[] {"/help", "/count", "/ping", "/exit"};
    private Integer counter;

    public Client(String ip, int port) {
        this.port = port;
        this.ip = ip;
        scanner = new Scanner(System.in);
        this.counter = 0;
    }

    public void plusCounter() {
        this.counter++;
    }

    public Integer getCounter() {
        return counter;
    }

    private Socket getSocket() throws IOException {
        Socket socket = new Socket(ip, port);
        return socket;
    }

    private void sendAndPrintMessage(SimpleMessage message) throws Exception {
        try (Connection connection = new Connection(getSocket())){
            StartTime = message.getDateTime();
            connection.sendMessage(message);
            SimpleMessage fromServer = connection.readMessage();
            EndTime = fromServer.getDateTime();
            System.out.println("ответ от сервера " + fromServer);
        }
    }

    public  void start() throws Exception {
        System.out.println("Введите имя");
        String name = scanner.nextLine();
        String text;
        while (true){
            System.out.println("Введите сообщение");
            text = scanner.nextLine();
            if (("/exit").equalsIgnoreCase(text)) {
                System.out.println("Выход");
                break;
            }else if(("/help").equalsIgnoreCase(text)) {
                System.out.println(Arrays.toString(commands));
            }else if(("/ping").equalsIgnoreCase(text)) {
                sendAndPrintMessage(SimpleMessage.getInstance(name,text));
                System.out.println("StartTime = " + StartTime);
                System.out.println("EndTime = " + EndTime);
                System.out.println("Ping = " +  ChronoUnit.MILLIS.between(StartTime, EndTime) + "ms");
            }else if(("/count").equalsIgnoreCase(text)) {
                sendAndPrintMessage(SimpleMessage.getInstance(name,text));
                System.out.println("clientCount = " + getCounter());
            }else {
                sendAndPrintMessage(SimpleMessage.getInstance(name,text));
            }
            plusCounter();
        }
    }

    public static void main(String[] args) {
        Properties properties = new Properties();
        try (
                InputStream input = Client.class
                        .getClassLoader()
                        .getResourceAsStream("example.properties")) {
            properties.load(input);
        }catch (IOException e){
            e.printStackTrace();
        }
        int port = Integer.parseInt(properties.getProperty("port","8090"));
        String ip = properties.getProperty("ip","127.0.0.1");
        try {
            new Client(ip,port).start();
        } catch (ConnectException e){
            System.out.println("Попробуйте подключится позднее");
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
}
