package com.db.tradestore.scheduler;

import com.db.tradestore.service.TradeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * @author Gangadi Kiran Kumar
 *
 */
@Slf4j
@Component
public class TradeScheduler {

    @Autowired
    private TradeService tradeService;

    /**
     * scheduler to update expired trades on every day
     */
    @Scheduled(cron = "${trade.scheduler.corn}")
    public void tradeExpiryScheduler() {
        log.info("running job");
        tradeService.updateTradeExpiry();
    }
}
