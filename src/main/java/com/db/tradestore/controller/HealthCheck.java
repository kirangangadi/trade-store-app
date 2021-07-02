package com.db.tradestore.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/ping")
public interface HealthCheck {

    @GetMapping
    public String healthCheck();

}
