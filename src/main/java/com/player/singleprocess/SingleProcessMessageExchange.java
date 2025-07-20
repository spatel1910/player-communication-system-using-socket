package com.player.singleprocess;

import com.player.common.MessageExchange;
import com.player.common.Message;

import java.util.concurrent.BlockingQueue;

public class SingleProcessMessageExchange implements MessageExchange {
    private final BlockingQueue<Message> ownQueue;
    private BlockingQueue<Message> peerQueue;

    public SingleProcessMessageExchange(BlockingQueue<Message> ownQueue) {
        this.ownQueue = ownQueue;
    }

    public void setPeerQueue(BlockingQueue<Message> peerQueue) {
        this.peerQueue = peerQueue;
    }

    @Override
    public void send(Message message) {
        peerQueue.offer(message);
    }

    @Override
    public Message receive() throws InterruptedException {
        return ownQueue.take();
    }

    @Override
    public void close() {}
}