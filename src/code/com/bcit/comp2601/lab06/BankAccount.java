/**
 * the following is a BankAccount class and implements various methods
 * @uthor : Percy Ratheko
 *
 *version 1.6
 */

package com.bcit.comp2601.lab06;

public class BankAccount {


    private final String accountID;

    private int balanceInUsd;

    private static final int STARTING_BALANCE_USD;


    static
    {
        STARTING_BALANCE_USD = 0;
    }

    /**
     * Constructor
     * @param accountID    : the account number of the user .
     * @param balanceInUsd : The balance of the user.
     */
    public BankAccount(final String accountID,
                       final int balanceInUsd)
    {
        validateAccount(accountID);
        this.accountID = accountID;
        this.balanceInUsd = balanceInUsd;
    }

    /**
     * gets the account number of the user.
     *
     * @return : returns the account number of the user.
     */
    public String getAccountID()
    {
        return accountID;
    }

    /**
     * gets the balance of the user.
     *
     * @return : returns the balance
     */
    public int getBalanceInUsd()
    {
        return balanceInUsd;
    }


    /**
     * deposits the money in the account
     *
     * @param amount: amount in USD to be deposited
     */
    public void deposit(int amount)
    {
        validateAmount(amount);
        this.balanceInUsd += amount;
    }


    /**
     * withdraws the money from the users account
     *
     * @param amount: amount to be withdrawn in USD
     */
    public void withdraw(int amount)
    {
        validateAmount(amount);
        this.balanceInUsd -= amount;
    }


    /**
     * Transfer money to another bank account.
     *
     * @param account1 : target bank account
     * @param amount        : amount to be transferred
     */
    public void transferToBank(BankAccount account1, int amount)
    {
        validateAmount(amount);
        this.withdraw(100);
        account1.deposit(100);
    }

    /**
     * validates the account.
     *
     * @param accountID : the account number
     */
    private static void validateAccount(final String accountID)
    {
        if(accountID == null || accountID.isBlank())
        {
            throw new IllegalArgumentException("Invalid account" + accountID);
        }
    }

    /**
     * validates amount before performing transactions
     *
     * @param amount : the amount .
     */
    private void validateAmount (final int amount)
    {
        if(amount <= STARTING_BALANCE_USD )
        {
            throw new IllegalArgumentException("Invalid account" + accountID);
        }
        if(amount > this.balanceInUsd)
        {
            throw new IllegalArgumentException("Invalid amount" + amount);
        }
    }


}
