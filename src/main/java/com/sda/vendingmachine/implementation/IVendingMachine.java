package com.sda.vendingmachine.implementation;

import com.sda.vendingmachine.bank.Coin;
import com.sda.vendingmachine.storage.Item;

import java.math.BigDecimal;
import java.util.Queue;

public interface IVendingMachine {

    Item getItem(int productCode);

    boolean payItem(int productCode, Queue<Coin> amountPaid);

    Queue<Coin> getChange(BigDecimal amountExpected, BigDecimal amountReceived);

    void cancelRequest();

}
