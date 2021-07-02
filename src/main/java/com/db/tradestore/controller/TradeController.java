package com.db.tradestore.controller;

import com.db.tradestore.model.Trade;
import com.db.tradestore.swagger.model.TradePutBadReqModel;
import com.db.tradestore.swagger.model.TradeGetNotFoundModel;
import io.swagger.annotations.*;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public interface TradeController {

	@GetMapping(value = "/trades")
	@ApiOperation(value = "Get all trades")
	@ApiResponses({ @ApiResponse(code = 200, message = "if there are no trees with in the given radius") })
	public List<Trade> getTrades();

	@GetMapping(value = "/trade/{id}")
	@ApiOperation(value = "Get trade by TradeId")
	@ApiResponses({ @ApiResponse(code = 200, message = "If the requested trade is available"),
			@ApiResponse(code = 404, message = "If the requested trade is not found in trade store", response = TradeGetNotFoundModel.class) })
	public Trade getTrade(
			@ApiParam(value = "To get Trades based on Trade id", required = true) @PathVariable("id") String id);

	@PutMapping("/trade/{id}")
	@ApiOperation(value = "Create or Update Trade by trade Id")
	@ApiResponses({ @ApiResponse(code = 200, message = "Trade is created or updated successfully"),
			@ApiResponse(code = 400, message = "either the Trade Version is lower than current. or Maturity date is invalid", response = TradePutBadReqModel.class) })
	public Trade updateTrade(@PathVariable("id") String id, @RequestBody Trade trade);
}
