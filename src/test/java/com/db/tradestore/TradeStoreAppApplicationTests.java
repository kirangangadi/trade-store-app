package com.db.tradestore;

import com.db.tradestore.controller.impl.TradeControllerImpl;
import com.db.tradestore.exception.BadRequestException;
import com.db.tradestore.exception.NotFoundException;
import com.db.tradestore.model.Trade;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@ExtendWith(SpringExtension.class)
@SpringBootTest
class TradeStoreAppApplicationTests {

    @Autowired
    private TradeControllerImpl tradeController;

    @Test
    void contextLoads() {
    }

    @Test
    @Order(1)
    void getAllTrades() {
        List<Trade> trades = tradeController.getTrades();
        Assertions.assertEquals(3, trades.size());
        Assertions.assertEquals("T1", trades.get(0).getTradeId());
    }

    @Test
    @Order(2)
    void getTradeById() {
        Trade trade = tradeController.getTrade("T1");
        Assertions.assertEquals("T1", trade.getTradeId());
        try {
            Trade notFound = tradeController.getTrade("T5");
        } catch (NotFoundException e) {
            Assertions.assertEquals("Cannot find trade with given id", e.getMessage());
            Assertions.assertEquals("404", e.getStatusCode());
        }
    }

    @Test
    @Order(3)
    void updateTradeOnIdMismatch() {
        try {
            tradeController.updateTrade("T4", createTrade("T5", 1, new Date()));
        } catch (BadRequestException e) {
            Assertions.assertEquals("Invalid Request. Trade id in request body and path param doesn't match.", e.getMessage());
            Assertions.assertEquals("400", e.getStatusCode());
        }
    }

    @Test
    @Order(4)
    void updateTradeOnInvalidVersion() {
        try {
            tradeController.updateTrade("T2", createTrade("T2", 1, new Date()));
        } catch (BadRequestException e) {
            Assertions.assertEquals("Invalid Request. Trade Version is lower than current.", e.getMessage());
            Assertions.assertEquals("400", e.getStatusCode());
        }
    }

    @Test
    @Order(5)
    void updateTradeInvalidMaturityDate() {

        try {
            tradeController.updateTrade("T2", createTrade("T2", 2, stringToDate("2020/06/30")));
        } catch (BadRequestException e) {
            Assertions.assertEquals("Invalid Request. Trade Maturity Date is earlier than current.", e.getMessage());
            Assertions.assertEquals("400", e.getStatusCode());
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    @Test
    @Order(6)
    void updateTrade() {

        Trade trade = tradeController.updateTrade("T4", createTrade("T4", 1, new Date()));
        Assertions.assertEquals("T4", trade.getTradeId());
    }

    private Trade createTrade(String tradeId, int version, Date maturityDate) {

        Trade trade = new Trade();
        trade.setTradeId(tradeId);
        trade.setBookId("B1");
        trade.setCreatedDate(new Date());
        trade.setExpired("N");
        trade.setCounterPartyId("CP-4");
        trade.setMaturityDate(maturityDate);
        trade.setVersion(version);
        return trade;
    }

    Date stringToDate(String date) throws ParseException {
        DateFormat format = new SimpleDateFormat("yyyy/MM/dd");
        return format.parse(date);
    }
}
