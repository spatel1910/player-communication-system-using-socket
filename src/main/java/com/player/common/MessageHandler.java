package com.player.common;

public interface MessageHandler {
    String generateInitialMessage(String playerName);
    String generateReplyMessage(String playerName, int replyCount);
}