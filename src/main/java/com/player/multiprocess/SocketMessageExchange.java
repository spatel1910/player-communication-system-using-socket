package com.player.multiprocess;

import com.player.common.Message;
import com.player.common.MessageExchange;

import java.io.*;
import java.net.*;

public class SocketMessageExchange implements MessageExchange {
    private final Socket socket;
    private final ObjectOutputStream outputStream;
    private final ObjectInputStream inputStream;

    public SocketMessageExchange(Socket socket) throws IOException {
        this.socket = socket;
        this.outputStream = new ObjectOutputStream(socket.getOutputStream());
        this.inputStream = new ObjectInputStream(socket.getInputStream());
    }

    @Override
    public void send(Message message) throws IOException {
        outputStream.writeObject(message);
        outputStream.flush();
    }

    @Override
    public Message receive() throws IOException, ClassNotFoundException {
        return (Message) inputStream.readObject();
    }

    @Override
    public void close() throws IOException {
        socket.close();
    }
}