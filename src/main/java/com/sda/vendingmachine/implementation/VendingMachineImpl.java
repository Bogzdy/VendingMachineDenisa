package com.sda.vendingmachine.implementation;

import com.sda.vendingmachine.bank.Bank;
import com.sda.vendingmachine.bank.Coin;
import com.sda.vendingmachine.exceptions.SoldOutException;
import com.sda.vendingmachine.storage.Item;
import com.sda.vendingmachine.storage.VendingStorage;
import lombok.Data;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Map;
import java.util.Queue;

@Data

public class VendingMachineImpl implements IVendingMachine {
    private VendingStorage storage;
    private Bank bank;

    public VendingMachineImpl(VendingStorage storage, Bank bank) {
        this.storage = storage;
        this.bank = bank;
    }

    public Item getItem(int productCode) {
        Map<Integer, Queue<Item>> storageMap = storage.getStorageMap();
        if (storageMap.get(productCode).size() == 0 || storageMap == null){
            throw new SoldOutException("Product not available!");
        }
       return storageMap.get(productCode).poll();
    }

    public boolean payItem(int productCode, Queue<Coin> amountPaid) {
        Item product = storage.getStorageMap().get(productCode).peek();
        BigDecimal amountP = exchangeCoins(amountPaid);
        if (amountP.compareTo(product.getPrice()) > 0 || amountP.compareTo(product.getPrice()) == 0){
            return true;
        }else {
            return false;
        }
    }

    public Queue<Coin> getChange(BigDecimal amountExpected, BigDecimal amountReceived) {
        return null;
    }

    public void cancelRequest() {

    }

    private BigDecimal exchangeCoins(Queue<Coin> coins){
        BigDecimal total = BigDecimal.ZERO;
        for (Coin coinEntry : coins){
            switch (coinEntry){
                case PENNY:
                    total = total.add(new BigDecimal(0.01));
                    break;
                case NICKLE:
                    total = total.add(new BigDecimal(0.05));
                    break;
                case DIME:
                    total = total.add(new BigDecimal(0.1));
                    break;
                case QUARTER:
                    total = total.add(new BigDecimal(0.25));
                    break;
                case HALF:
                    total = total.add(new BigDecimal(0.5));
                    break;
                case ONE_DOLLAR:
                    total = total.add(new BigDecimal(1));
            }
        }
        return total.setScale(2, RoundingMode.HALF_EVEN);
    }
}
