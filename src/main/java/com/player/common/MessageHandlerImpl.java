package com.player.common;




public class MessageHandlerImpl implements MessageHandler {

    @Override
    public String generateInitialMessage(String playerName) {
        return "Hello from initiator";
    }

    @Override
    public String generateReplyMessage(String playerName, int replyCount) {
        return String.format("reply #%d from %s", replyCount, playerName);
    }
}