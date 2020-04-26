package com.priceminister.account.implementation;

import com.priceminister.account.*;


public class CustomerAccount implements Account {

    private Double accountBalance;

    public void add(Double addedAmount) {
        isAmountPositive(addedAmount);
        this.setAccountBalance(this.getAccountBalance() + addedAmount);
    }

    public Double withdrawAndReportBalance(Double withdrawnAmount, AccountRule rule) {
        isAmountPositive(withdrawnAmount);
        isRuleNotNull(rule);
        Double resultBalance = this.getAccountBalance() - withdrawnAmount;
        if (rule.withdrawPermitted(resultBalance)){
            this.setAccountBalance(resultBalance);
            return this.getAccountBalance();
        }
        else {
            throw new IllegalBalanceException(resultBalance);
        }
    }

    private void isRuleNotNull(AccountRule rule) {
        if(rule == null){
            throw new IllegalArgumentException();
        }
    }

    private void isAmountPositive(Double addedAmount) {
        if (addedAmount <= 0) {
            throw new IllegalArgumentException();
        }
    }

    public Double getAccountBalance() {
        return this.accountBalance != null ? this.accountBalance : 0.0;
    }

    public void setAccountBalance(Double accountBalance){
        this.accountBalance = accountBalance;
    }

}
