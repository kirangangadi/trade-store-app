package com.db.tradestore.controller.impl;

import com.db.tradestore.controller.HealthCheck;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HealthCheckControllerImpl implements HealthCheck {

    @Override
    public String healthCheck() {
        return "health is okay";
    }
}
