package com.db.tradestore.swagger.model;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TradeMaturityModel {

    @ApiModelProperty(example = "Invalid Request. Trade Maturity Date is earlier than current.")
    private String message;
    @ApiModelProperty(example = "400")
    private String status;
}
