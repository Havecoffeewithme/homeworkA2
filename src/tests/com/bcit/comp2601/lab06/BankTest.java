/**
 * the following is a Bank Tester
 * @uthor : Percy Ratheko
 *
 *version 1.6
 */

package com.bcit.comp2601.lab06;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BankTest {

    Bank bank1;
    Bank bank2;



    @org.junit.jupiter.api.BeforeEach
    void setUp()
    {
        bank1 = new Bank();
        bank2 = new Bank();


    }


    @org.junit.jupiter.api.AfterEach
    void tearDown()
    {
        bank1 = null;
        bank2= null;
    }

    @Test
    void addingAndRetrievingAccountFromBank() {
        BankAccount newAccount = new BankAccount("54321", 100);
        bank2.addAccount(newAccount);
        assertEquals(newAccount, bank2.retrieveAccount("54321"));

        BankAccount newAccount2 = new BankAccount("11111", 300);
        bank1.addAccount(newAccount2);
        assertEquals(newAccount2, bank1.retrieveAccount("11111"));
    }

    @Test
    void handlingInvalidAccountRetrieval()
    {
        IllegalArgumentException exception1 = assertThrows(IllegalArgumentException.class, () -> bank1.retrieveAccount("99999"));
        assertEquals("Account not found", exception1.getMessage());
        IllegalArgumentException exception2 = assertThrows(IllegalArgumentException.class, () -> bank2.retrieveAccount("00000"));
        assertEquals("Account not found", exception2.getMessage());
    }









}