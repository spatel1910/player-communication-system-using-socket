package com.player.common;

public interface MessageExchange {
    void send(Message message) throws Exception;
    Message receive() throws Exception;
    void close() throws Exception;
}