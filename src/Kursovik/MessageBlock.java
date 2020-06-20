package Kursovik;

import java.net.Socket;

public class MessageBlock {
    private MessageText message;
    private Connection connection;

    public MessageBlock(MessageText message, Connection connection) {
        this.message = message;
        this.connection = connection;
    }

    public MessageText getMessage() {
        return message;
    }

    public Connection getConnection() {
        return connection;
    }
}
