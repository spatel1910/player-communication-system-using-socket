package com.player.common;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

public class MessageCoordinator {
    private final Map<String, AtomicInteger> playerMessageCount = new ConcurrentHashMap<>();
    private final AtomicBoolean isCommunicationEnded = new AtomicBoolean(false);

    public int incrementMessageCount(String playerName) {
        playerMessageCount.computeIfAbsent(playerName, k -> new AtomicInteger(0));
        return playerMessageCount.get(playerName).incrementAndGet();
    }

    public boolean hasCommunicationEnded() {
        return isCommunicationEnded.get();
    }

    public void endCommunication() {
        isCommunicationEnded.set(true);
    }
}