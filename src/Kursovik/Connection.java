package Kursovik;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class Connection {
    private Socket clientSocket;
    private ObjectInputStream input;
    private ObjectOutputStream output;

    public Connection(Socket clientSocket, ObjectInputStream input, ObjectOutputStream output) {
        this.clientSocket = clientSocket;
        this.input = input;
        this.output = output;
    }

    public Socket getClientSocket() {
        return clientSocket;
    }

    public void sendMessage(MessageText message) throws IOException {
        message.setDateTime();
        output.writeObject(message);
        output.flush();
    }

    public MessageText readMessage() throws IOException, ClassNotFoundException {
        return (MessageText) input.readObject();
    }

    public void close() throws Exception {
        input.close();
        output.close();
        clientSocket.close();
    }
}
