package com.garage.usagedata;

import lombok.extern.slf4j.Slf4j;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisSentinelPool;
import redis.clients.jedis.exceptions.JedisException;

import java.net.Socket;
import java.util.HashSet;
import java.util.Set;

@Slf4j
public class JedisTestSentinelEndpoint {

    private static final String MASTER_NAME = "mymaster";
    public static final String PASSWORD = "foobared";
    private static final Set sentinels;
    static {
        sentinels = new HashSet();
        sentinels.add("169.56.108.4:30401");
        sentinels.add("169.56.108.4:30402");
        sentinels.add("169.56.108.4:30403");
    }
    public JedisTestSentinelEndpoint() {
    }
    private void runTest() throws InterruptedException {
        boolean writeNext = true;
        JedisSentinelPool pool = new JedisSentinelPool(MASTER_NAME, sentinels);
        Jedis jedis = null;
        while (true) {
            try {
                log.debug("Fetching connection from pool");
                jedis = pool.getResource();
                log.debug("Authenticating...");
                log.debug("auth complete...");
                Socket socket = jedis.getClient().getSocket();
                log.debug("Connected to " + socket.getRemoteSocketAddress());
                while (true) {
                    if (writeNext) {
                        log.debug("Writing...");
                        jedis.set("java-key-999", "java-value-999");
                        writeNext = false;
                    } else {
                        log.debug("Reading...");
                        jedis.get("java-key-999");
                        writeNext = true;
                    }
                    Thread.sleep(2 * 1000);
                }
            } catch (JedisException e) {
                log.debug("Connection error of some sort!");
                log.debug(e.getMessage());
                Thread.sleep(2 * 1000);
            } finally {
                if (jedis != null) {
                    jedis.close();
                }
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        new JedisTestSentinelEndpoint().runTest();
    }
}
