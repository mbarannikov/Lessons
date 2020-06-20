package Kursovik;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.time.LocalDateTime;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.LinkedBlockingDeque;

public class Server {

    public static void main(String[] args) throws IOException {
//        ConcurrentHashMap<Socket, ObjectOutputStream> socketMap = new ConcurrentHashMap<>();
        CopyOnWriteArrayList<Connection> connections = new CopyOnWriteArrayList<>();
        LinkedBlockingDeque<MessageBlock> messageBlocks = new LinkedBlockingDeque<>();
        Properties properties = new Properties();
        try (
                InputStream input = Server.class
                        .getClassLoader()
                        .getResourceAsStream("example.properties")) {
            properties.load(input);
        } catch (IOException e) {
            e.printStackTrace();
        }
        int port = Integer.parseInt(properties.getProperty("port", "8090"));

        try (ServerSocket serverSocket = new ServerSocket(port)) {
            System.out.println("Сервер запущен... ");
            System.out.println("Server socket open = " + serverSocket.getLocalSocketAddress());
            new Thread(new Sender(connections, messageBlocks)).start();
            while (true) {
                Socket clientSocket = serverSocket.accept();
                System.out.println("Client socket accept = " + clientSocket.getRemoteSocketAddress() + " " + clientSocket.getLocalSocketAddress());
                new Thread(new Reader(clientSocket, connections, messageBlocks)).start();
            }
        }
    }

    private static class Sender extends Worker {
        //        ConcurrentHashMap<Socket, ObjectOutputStream> socketMap;
//        private Socket clientSocket;
//        private ObjectOutputStream output;
        CopyOnWriteArrayList<Connection> connections;
        private LinkedBlockingDeque<MessageBlock> messageBlocks;
        private MessageBlock messageBlock;
        private MessageText message;

        public Sender(CopyOnWriteArrayList<Connection> connections, LinkedBlockingDeque<MessageBlock> messageBlocks) {
            this.connections = connections;
            this.messageBlocks = messageBlocks;
        }

        @Override
        protected void init() throws Exception {
            System.out.println("Поток Sender запущен... " + Thread.currentThread().getName());
        }
//
//        @Override
//        protected void stop() throws Exception {
//            super.stop();
//        }

        @Override
        protected void loop() throws Exception {
            messageBlock = messageBlocks.take();
            message = messageBlock.getMessage();
            message.setText("from Server " + message.getText());
            System.out.println("Server Sender " + Thread.currentThread().getName() + " " + message);
            for (Connection connection : connections
            ) {
                if (connection != messageBlock.getConnection()) {
                    connection.sendMessage(message);
                }
            }

//            for (Map.Entry<Socket, ObjectOutputStream> entry: socketMap.entrySet()
//            ) {
//                if (clientSocket != entry.getKey()) {
//                    output = entry.getValue();
//                    output.writeObject(message);
//                    output.flush();
//                }
//            }
        }
    }

    private static class Reader extends Worker {
        private Socket clientSocket;
        private ObjectOutputStream output;
        private ObjectInputStream input;
        private MessageText message;
        //        ConcurrentHashMap<Socket, ObjectOutputStream> socketMap;
        private LinkedBlockingDeque<MessageBlock> messageBlocks;
        private MessageBlock messageBlock;
        private CopyOnWriteArrayList<Connection> connections;
        private Connection connection;

        public Reader(Socket clientSocket, CopyOnWriteArrayList<Connection> connections, LinkedBlockingDeque<MessageBlock> messageBlocks) {
            this.clientSocket = clientSocket;
            this.connections = connections;
            this.messageBlocks = messageBlocks;
        }

        @Override
        protected void init() throws Exception {
            System.out.println("Поток Reader запущен... " + Thread.currentThread().getName());
            output = new ObjectOutputStream(clientSocket.getOutputStream());
            input = new ObjectInputStream(clientSocket.getInputStream());
            connection = new Connection(clientSocket, input, output);
//            socketMap.putIfAbsent(clientSocket, output);
            connections.addIfAbsent(connection);
        }

        @Override
        protected void loop() throws Exception {
            message = connection.readMessage();
            System.out.println("Server Reader " + Thread.currentThread().getName() + " " + message);
            messageBlock = new MessageBlock(message, connection);
            messageBlocks.put(messageBlock);
        }

        @Override
        protected void stop() throws Exception {
            System.out.println("Client connection close = " + connection.getClientSocket().getRemoteSocketAddress());
            connections.remove(connection);
            connection.close();
        }
    }
}
