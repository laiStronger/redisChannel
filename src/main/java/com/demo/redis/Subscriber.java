package com.demo.redis;

import org.apache.log4j.Logger;
import redis.clients.jedis.JedisPubSub;

public class Subscriber extends JedisPubSub {//注意这里继承了抽象类JedisPubSub

    private static final Logger LOGGER = Logger.getLogger(Subscriber.class);

    @Override
    public void onMessage(String channel, String message) {
        System.out.println(String.format("Message. Channel: %s, Msg: %s", channel, message));
    }

    @Override
    public void onPMessage(String pattern, String channel, String message) {
        System.out.println(String.format("PMessage. Pattern: %s, Channel: %s, Msg: %s", 
            pattern, channel, message));
    }

    @Override
    public void onSubscribe(String channel, int subscribedChannels) {
        System.out.println("onSubscribe");
    }

    @Override
    public void onUnsubscribe(String channel, int subscribedChannels) {
        System.out.println("onUnsubscribe");
    }

    @Override
    public void onPUnsubscribe(String pattern, int subscribedChannels) {
        System.out.println("onPUnsubscribe");
    }

    @Override
    public void onPSubscribe(String pattern, int subscribedChannels) {
        System.out.println("onPSubscribe");
    }
}