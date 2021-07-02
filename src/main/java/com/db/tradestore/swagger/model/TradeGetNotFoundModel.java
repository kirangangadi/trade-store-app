package com.db.tradestore.swagger.model;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TradeGetNotFoundModel {

    @ApiModelProperty(example = "Cannot find trade with given id")
    private String message;
    @ApiModelProperty(example = "404")
    private String status;
}
