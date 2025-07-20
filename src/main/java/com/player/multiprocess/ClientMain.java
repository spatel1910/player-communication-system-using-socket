package com.player.multiprocess;

import com.player.common.MessageExchange;
import com.player.common.MessageHandler;
import com.player.common.MessageHandlerImpl;
import com.player.common.MessageCoordinator;
import com.player.common.Player;

import java.net.Socket;

public class ClientMain {
    public static void main(String[] args) throws Exception {
        Socket socket = new Socket("localhost", 6000);
        MessageExchange messageExchange = new SocketMessageExchange(socket);
        MessageHandler handler = new MessageHandlerImpl();
        MessageCoordinator coordinator = new MessageCoordinator();

        Player player = new Player("Player-1", true, messageExchange, coordinator, handler);
        player.run();
    }
}