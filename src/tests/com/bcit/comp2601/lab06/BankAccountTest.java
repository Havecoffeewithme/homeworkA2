/**
 * the following is a BankAccount Tester
 * @uthor : Percy Ratheko
 *
 *version 1.6
 */

package com.bcit.comp2601.lab06;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BankAccountTest {

    BankAccount bankAccount1;
    BankAccount bankAccount2;

    @BeforeEach
    void setUp()
    {

        bankAccount1 = new BankAccount("12345", 1000);
        bankAccount2 = new BankAccount("67890", 500);


    }

    @AfterEach
    void tearDown()
    {
        bankAccount1 = null;
        bankAccount2 = null;
    }



    @Test
    void testDeposit()
    {
        bankAccount1.deposit(300);
        assertEquals(1300,bankAccount1.getBalanceInUsd());

        bankAccount2.deposit(500);
        assertEquals(1000,bankAccount2.getBalanceInUsd());

    }

    @Test
    void testWithdraw()
    {
        bankAccount1.withdraw(100);
        assertEquals(900,bankAccount1.getBalanceInUsd());

        bankAccount1.withdraw(50);
        assertEquals(500,bankAccount2.getBalanceInUsd());
    }

    @Test
    void transferBetweenBankAccountsAndVerifyBalances() {
        bankAccount1.transferToBank(bankAccount2,  200);
        assertEquals(900, bankAccount1.getBalanceInUsd());
        assertEquals(700, bankAccount2.getBalanceInUsd());

        bankAccount2.transferToBank(bankAccount1,  100);
        assertEquals(900, bankAccount1.getBalanceInUsd());
        assertEquals(600, bankAccount2.getBalanceInUsd());
    }













}