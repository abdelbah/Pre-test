package com.priceminister.account;


public class IllegalBalanceException extends RuntimeException {
    
    private static final long serialVersionUID = -9204191749972551939L;
    
	private final Double balance;
    
    public IllegalBalanceException(Double illegalBalance) {
        balance = illegalBalance;
    }

    @Override
    public String toString() {
        return "Illegal account balance: " + balance;
    }
}
