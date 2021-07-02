package com.db.tradestore.service;

import com.db.tradestore.model.Trade;
import com.db.tradestore.repository.TradeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class TradeService {

    @Autowired
    private TradeRepository tradeRepository;

    public List<Trade> findAllTrades() {
        return tradeRepository.findAll();
    }

    public Trade getTrade(String tradeId) {
        return tradeRepository.getTradesByTradeId(tradeId);
    }

    public void persist(Trade save) {
        tradeRepository.save(save);
    }

    public void merge(Trade trade, Trade existing) {
        existing.setBookId(trade.getBookId());
        existing.setCounterPartyId(trade.getCounterPartyId());
        existing.setExpired(trade.getExpired());
        existing.setMaturityDate(trade.getMaturityDate());
        existing.setVersion(trade.getVersion());
        persist(existing);
    }

    public boolean isValidVersion(Integer newVersion, Integer oldVersion) {
        return newVersion >= oldVersion;
    }

    public boolean isValidMaturityDate(Date maturityDate) {
        return maturityDate.after(new Date());
    }

    public void updateTradeExpiry() {
        tradeRepository.updateExpiredTrades();
    }

    /**
     * both the trade id's in path param and request body should match
     * @param pathId Trade id passed in path param
     * @param bodyTradeId Trade ID sent by client in request body
     * @return boolean value
     */
    public boolean isValidTrade(String pathId, String bodyTradeId) {
        return pathId.equals(bodyTradeId);
    }
}
