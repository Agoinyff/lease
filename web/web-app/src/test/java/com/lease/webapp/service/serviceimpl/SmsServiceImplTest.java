package com.lease.webapp.service.serviceimpl;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class SmsServiceImplTest {

    @Autowired
    private SmsServiceImpl smsService;

    @Test
    void sendCode() {
        smsService.sendCode("18039760054", "1234");
    }

}