package com.db.tradestore.exception;

public class TradeErrorCodes {

    private TradeErrorCodes() {

    }

    public static final String TS_EXEC_00 = "Cannot find trade with given id";
    public static final String TS_EXEC_01 = "Invalid Request. Trade Version is lower than current.";
    public static final String TS_EXEC_02 = "Invalid Request. Trade Maturity Date is earlier than current.";
    public static final String TS_EXEC_03 = "Invalid Request. Trade id in request body and path param doesn't match.";
}
