package com.db.tradestore.swagger.model;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class TradePutBadReqModel {

    @ApiModelProperty(example = "[{\"message\": \"Invalid Request. Trade Maturity Date is earlier than current.\", \"status\": 400 },{ \"message\": \"Invalid Request. Trade Version is lower than current.\", \"status\": 400 }, { \"message\": \"Invalid Request. Trade id in request body and path param doesn't match.\", \"status\": 400 }]")
    List<String> message;
}
