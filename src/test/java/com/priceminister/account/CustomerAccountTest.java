package com.priceminister.account;


import static org.junit.Assert.*;

import org.junit.*;

import com.priceminister.account.implementation.*;


/**
 * Please create the business code, starting from the unit tests below.
 * Implement the first test, the develop the code that makes it pass.
 * Then focus on the second test, and so on.
 * 
 * We want to see how you "think code", and how you organize and structure a simple application.
 * 
 * When you are done, please zip the whole project (incl. source-code) and send it to recrutement-dev@priceminister.com
 * 
 */
public class CustomerAccountTest {

    private static final double AMOUNT = 200.00;
    private Account customerAccount;
    private AccountRule rule;

    @Before
    public void setUp(){
        customerAccount = new CustomerAccount();
        rule = new CustomerAccountRule();
        rule.setAccountType(AccountType.BASIC);
    }

    /**
     * Tests that an empty account always has a balance of 0.0, not a NULL.
     */
    @Test
    public void accountWithoutMoneyShouldHaveZeroBalance() {
        assertEquals(0.0, customerAccount.getAccountBalance(), 0);
    }

    @Test
    public void accountWithMoneyShouldHavePositiveBalance() {
        customerAccount.setAccountBalance(AMOUNT);
        assertTrue(customerAccount.getAccountBalance() > 0);
    }
    
    /**
     * Adds money to the account and checks that the new balance is as expected.
     */
    @Test
    public void addShouldAcceptPositiveAmount() {
        customerAccount.add(AMOUNT);
        assertEquals(AMOUNT, customerAccount.getAccountBalance(), 0);
    }

    @Test(expected = IllegalArgumentException.class)
    public void addShouldNotAcceptNegativeAmount() {
        customerAccount.add(-AMOUNT);
    }

    @Test(expected = IllegalArgumentException.class)
    public void addShouldNotAcceptZeroAmount() {
        customerAccount.add(0.0);
    }
    
    /**
     * Tests that an illegal withdrawal throws the expected exception.
     * Use the logic contained in CustomerAccountRule; feel free to refactor the existing code.
     */
    @Test(expected = IllegalBalanceException.class)
    public void withdrawAndReportBalanceDeniesIllegalBalance() throws IllegalBalanceException {
        customerAccount.withdrawAndReportBalance(500.00, rule);
    }

    @Test(expected = IllegalArgumentException.class)
    public void withdrawAndReportBalanceGetsNegativeWithrawnAmountAndThrowsException() throws IllegalBalanceException {
        customerAccount.withdrawAndReportBalance(-500.00, rule);
    }

    @Test(expected = IllegalArgumentException.class)
    public void withdrawAndReportBalanceGetsZeroWithdrawAmountAndThrowsException() throws IllegalBalanceException {
        customerAccount.withdrawAndReportBalance(0.00, rule);
    }

    @Test(expected = IllegalArgumentException.class)
    public void withdrawAndReportBalanceGetsWithNullRuleThrowsException() throws IllegalBalanceException {
        customerAccount.withdrawAndReportBalance(0.00, null);
    }

    @Test
    public void withdrawAndReportBalanceShouldReturnPositiveBalance(){
        customerAccount.setAccountBalance(AMOUNT);
        customerAccount.withdrawAndReportBalance(150.00, rule);
        assertEquals(50.00, customerAccount.getAccountBalance(), 0);
    }

    @Test
    public void withdrawAndReportBalanceShouldReturnZeroBalance(){
        customerAccount.setAccountBalance(AMOUNT);
        customerAccount.withdrawAndReportBalance(AMOUNT, rule);
        assertEquals(0.0, customerAccount.getAccountBalance(), 0);
    }
}
