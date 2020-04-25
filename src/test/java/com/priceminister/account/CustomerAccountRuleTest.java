package com.priceminister.account;

import com.priceminister.account.implementation.CustomerAccountRule;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class CustomerAccountRuleTest {

    private AccountRule rule;
    @Before
    public void setUp(){
        rule = new CustomerAccountRule();
    }
    @Test
    public void withdrawPermittedForPremiumShouldReturnTrue(){
        rule.setAccountType(AccountType.PREMIUM);
        assertTrue(rule.withdrawPermitted(-500.00));
    }

    @Test
    public void withdrawPermittedForPremiumShouldReturnFalse(){
        rule.setAccountType(AccountType.PREMIUM);
        assertFalse(rule.withdrawPermitted(-700.00));
    }

    @Test
    public void withdrawPermittedForBasicShouldReturnTrue(){
        rule.setAccountType(AccountType.BASIC);
        assertTrue(rule.withdrawPermitted(0.00));
    }

    @Test
    public void withdrawPermittedForBasicShouldReturnFalse(){
        rule.setAccountType(AccountType.BASIC);
        assertFalse(rule.withdrawPermitted(-100.00));
    }
}
