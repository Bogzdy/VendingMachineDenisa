package com.sda.vendingmachine.bank;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Queue;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class Bank {
    private Queue<Coin> pennyStack;
    private Queue<Coin> nickelStack;
    private Queue<Coin> dimeStack;
    private Queue<Coin> halfStack;
    private Queue<Coin> quarterStack;
    private Queue<Coin> oneDollarStack;

    @Override
    public String toString() {
        return "Bank \n" +
                "pennyStack = " + pennyStack.size() +
                "\nnickleStack = " + nickelStack.size() +
                "\ndimeStack = " + dimeStack.size() +
                "\nhalfStack = " + halfStack.size() +
                "\nquarterStack = " + quarterStack.size() +
                "\noneDollarStack = " + oneDollarStack.size();
    }
}
