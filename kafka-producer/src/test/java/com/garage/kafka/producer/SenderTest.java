package com.garage.kafka.producer;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SenderTest {

    @Autowired
    private Sender sender;

    @Test
    public void send() {

        for ( int i = 0 ; i < 10 ; i++ ) {

            sender.send("{\"ipAddr\":\"127.0.0.1\", \"uriInfo\":\"ddd\", \"svcContId\":\"680350947\", \"svcNo\":\"01029050326\", \"prodId\":\"aaa\", \"succYn\":\"Y\"}");
        }


    }
}