package com.player.singleprocess;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

import com.player.common.*;


public class SingleProcessMain {
    public static void main(String[] args) {

        MessageCoordinator coordinator = new MessageCoordinator();
        BlockingQueue<Message> initiatorQueue = new ArrayBlockingQueue<>(20);
        BlockingQueue<Message> responderQueue = new ArrayBlockingQueue<>(20);

        SingleProcessMessageExchange initiatorSME = new SingleProcessMessageExchange(initiatorQueue);
        SingleProcessMessageExchange responderSME = new SingleProcessMessageExchange(responderQueue);

        initiatorSME.setPeerQueue(responderQueue);
        responderSME.setPeerQueue(initiatorQueue);

        MessageHandler handler = new MessageHandlerImpl();

        Player initiator = new Player("Player-1", true, initiatorSME, coordinator, handler);
        Player responder = new Player("Player-2", false, responderSME, coordinator, handler);

        new Thread(initiator).start();
        new Thread(responder).start();
    }
}