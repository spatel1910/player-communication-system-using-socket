package com.player.multiprocess;

import com.player.common.MessageExchange;
import com.player.common.MessageHandler;
import com.player.common.MessageHandlerImpl;
import com.player.common.MessageCoordinator;
import com.player.common.Player;

import java.net.ServerSocket;
import java.net.Socket;

public class ServerMain {
    public static void main(String[] args) throws Exception {
        ServerSocket serverSocket = new ServerSocket(6000);
        Socket clientSocket = serverSocket.accept();

        MessageExchange messageExchange = new SocketMessageExchange(clientSocket);
        MessageHandler handler = new MessageHandlerImpl();
        MessageCoordinator coordinator = new MessageCoordinator();

        Player player = new Player("Player-2", false, messageExchange, coordinator, handler);
        player.run();

        serverSocket.close();
    }
}