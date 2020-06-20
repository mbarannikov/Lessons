package Kursovik;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ConnectException;
import java.net.Socket;
import java.time.LocalDateTime;
import java.util.Properties;
import java.util.Scanner;

public class Client {

    public static void main(String[] args) throws IOException {
        Properties properties = new Properties();
        try (
                InputStream input = Client.class
                        .getClassLoader()
                        .getResourceAsStream("example.properties")) {
            properties.load(input);
        } catch (IOException e) {
            e.printStackTrace();
        }
        int port = Integer.parseInt(properties.getProperty("port", "8090"));
        String ip = properties.getProperty("ip", "127.0.0.1");
        try {
            Socket socket = new Socket(ip, port);
            System.out.println("Клиент запущен... ");
            System.out.println("Socket open = " + socket.getLocalSocketAddress() + " " + socket.getRemoteSocketAddress());
            new Thread(new Reader(socket)).start();
            new Thread(new Sender(socket)).start();
        } catch (ConnectException e) {
            System.out.println("Попробуйте подключится позднее");
        }

    }

    private static class Reader extends Worker {
        private ObjectInputStream in;
        private Socket socket;

        public Reader(Socket socket) {
            this.socket = socket;
        }

        @Override
        protected void init() throws IOException {
            System.out.println("Поток Reader запущен... " + Thread.currentThread().getName());
            in = new ObjectInputStream(socket.getInputStream());
        }

        @Override
        protected void loop() throws IOException, ClassNotFoundException {
            MessageText messFromServer = (MessageText) in.readObject();
            System.out.println("сообщение от сервера " + messFromServer);
        }

        @Override
        protected void stop() throws IOException {
            System.out.println("Reader socket close = " + socket.getLocalSocketAddress());
            in.close();
            socket.close();
        }
    }

    private static class Sender extends Worker {
        private ObjectOutputStream out;
        private Socket socket;
        private Scanner scanner;
        private String name;
        private String text;
        private MessageText message;

        public Sender(Socket socket) {
            this.socket = socket;
        }

        @Override
        protected void init() throws IOException {
            System.out.println("Поток Sender запущен... " + Thread.currentThread().getName());
            out = new ObjectOutputStream(socket.getOutputStream());
            scanner = new Scanner(System.in);
            System.out.println("Ведите имя клиента");
            name = scanner.nextLine();
        }

        @Override
        protected void loop() throws IOException {
            System.out.println("Введите сообщение ");
            text = scanner.nextLine();
            message = MessageText.getInstance(name, text);
            message.setDateTime();
            out.writeObject(message);
            out.flush();
        }

        @Override
        protected void stop() throws IOException {
            System.out.println("Sender socket close = " + socket.getLocalSocketAddress());
            out.close();
            socket.close();
        }
    }
}
