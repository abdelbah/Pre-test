package com.priceminister.account;

public enum AccountType {
    PREMIUM((double) -500),
    BASIC((double) 0);

    private Double limit;

    AccountType(Double limit){
        this.limit = limit;
    }

    public Double limit(){
        return limit;
    }
}
