/**
 * the following is a Bank class , it performs various methods.
 *
 * @uthor : Percy Ratheko
 *
 *version 1.6
 */


package com.bcit.comp2601.lab06;

import java.util.ArrayList;
import java.util.List;

public class Bank {

    private final List<BankAccount> accounts;

    public Bank()
    {

        accounts = new ArrayList<>();

    }

    /**
     * Adds bank account
     *
     * @param account
     */
    public void addAccount(BankAccount account)
    {
        validateAccount(account);
        accounts.add(account);
    }

    /**
     *
     * retrieves the account number
     *
     * @param accountID : the account number
     * @return : the account
     */
    public BankAccount retrieveAccount(String accountID)
    {
        for (BankAccount account : accounts) {
            if (account.getAccountID().equals(accountID)) {
                return account;
            }
        }
        throw new IllegalArgumentException("Account not found" );
    }

    /**
     *
     * @return : The total balance
     */
    public int totalBalanceUsd()
    {
        int total = 0;
        for (BankAccount account : accounts) {
            total += account.getBalanceInUsd();
        }
        return total;
    }


    /**
     * validates accounts
     *
     * @param account: the account
     */
    private static void validateAccount(final BankAccount account)
    {
        if(account == null )
        {
            throw new IllegalArgumentException("account cannot be null " + account);
        }
    }


}
