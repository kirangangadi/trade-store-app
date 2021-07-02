package com.db.tradestore.controller.impl;

import com.db.tradestore.controller.TradeController;
import com.db.tradestore.model.Trade;
import com.db.tradestore.exception.BadRequestException;
import com.db.tradestore.exception.NotFoundException;
import com.db.tradestore.exception.TradeErrorCodes;
import com.db.tradestore.service.TradeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TradeControllerImpl implements TradeController {

    @Autowired
    private TradeService tradeService;

    @Override
    public List<Trade> getTrades() {
        return tradeService.findAllTrades();
    }

    @Override
    public Trade getTrade(String id) {
        Trade trade = tradeService.getTrade(id);
        if (trade != null) {
            return trade;
        } else
            throw new NotFoundException(TradeErrorCodes.TS_EXEC_00, "404");
    }

    @Override
    public Trade updateTrade(String id, Trade reqTrade) {

        if (tradeService.isValidTrade(id, reqTrade.getTradeId())) {
            Integer reqVersion = reqTrade.getVersion();
            Trade existingTrade = tradeService.getTrade(reqTrade.getTradeId());
            if (existingTrade != null) {
                /*
                 *if the lower version is being received by the store, it should reject the trade with 400 Response code
                 */
                if (!tradeService.isValidVersion(reqVersion, existingTrade.getVersion())) {
                    throw new BadRequestException(TradeErrorCodes.TS_EXEC_01, "400");
                }
                /*
                 *Store should not allow the trade which has less maturity date then today date. It should return Response with 400
                 */
                if (!tradeService.isValidMaturityDate(reqTrade.getMaturityDate())) {
                    throw new BadRequestException(TradeErrorCodes.TS_EXEC_02, "400");
                }
                tradeService.merge(reqTrade, existingTrade);
            } else {
                //create trade since it not exist in trade store
                tradeService.persist(reqTrade);
            }
            return reqTrade;
        } else
            // Trade id in request body and path param doesn't match then 400 response code should be sent
            throw new BadRequestException(TradeErrorCodes.TS_EXEC_03, "400");
    }
}
