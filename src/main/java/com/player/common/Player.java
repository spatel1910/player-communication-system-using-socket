package com.player.common;

import java.io.IOException;
import java.util.concurrent.atomic.AtomicInteger;

public class Player implements Runnable {
    private final String playerName;
    private final boolean isInitiator;
    private final MessageExchange messageExchange;
    private final MessageCoordinator coordinator;
    private final AtomicInteger replyCounter = new AtomicInteger(0);
    private final MessageHandler messageHandler;

    public Player(String playerName, boolean isInitiator, MessageExchange messageExchange,
                  MessageCoordinator coordinator, MessageHandler messageHandler) {
        this.playerName = playerName;
        this.isInitiator = isInitiator;
        this.messageExchange = messageExchange;
        this.coordinator = coordinator;
        this.messageHandler = messageHandler;
    }


    @Override
    public void run() {
        long pid = ProcessHandle.current().pid();
        System.out.println(playerName + " started in PID: " + pid + "\n");

        try {
            if (isInitiator) {
                messageExchange.send(new Message(playerName, messageHandler.generateInitialMessage(playerName)));
            }

            while (!coordinator.hasCommunicationEnded()) {
                Thread.sleep(2000);
                Message received = messageExchange.receive();
                System.out.println(playerName + " received " + received.getContent());

                if (!coordinator.hasCommunicationEnded()) {
                    int replyCount = replyCounter.incrementAndGet();
                    String reply = messageHandler.generateReplyMessage(playerName, replyCount);
                    messageExchange.send(new Message(playerName, reply));

                    if (isInitiator && coordinator.incrementMessageCount(playerName) >= 10) {
                        coordinator.endCommunication();
                        break;
                    }
                }
            }
        } catch (Exception e) {
            System.err.println(playerName + " error: " + e.getMessage());
        } finally {
            try {
                messageExchange.close();
            } catch (IOException e) {
                e.printStackTrace();
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
    }
}