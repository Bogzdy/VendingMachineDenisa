package com.sda.vendingmachine;

import com.sda.vendingmachine.bank.Bank;
import com.sda.vendingmachine.bank.Coin;
import com.sda.vendingmachine.implementation.VendingMachineImpl;
import com.sda.vendingmachine.storage.Item;
import com.sda.vendingmachine.storage.VendingStorage;

import java.math.BigDecimal;
import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Map;
import java.util.Queue;

public class VendingMachineTest {
    public static void main(String[] args) {
        Item chocolate = new Item(1, "Ciocolata Heidi", BigDecimal.valueOf(5));
        Item sparklingWater = new Item(2, "Dorna", BigDecimal.valueOf(2));
        Item cocaCola = new Item(3, "Coca Cola", BigDecimal.valueOf(10));

        Queue<Item> chocolateItemQueue = new ArrayDeque<Item>();
        chocolateItemQueue.add(chocolate);
        chocolateItemQueue.add(chocolate);
        chocolateItemQueue.add(chocolate);

        Queue<Item> waterItemQueue = new ArrayDeque<Item>();
        waterItemQueue.add(sparklingWater);
        waterItemQueue.add(sparklingWater);
        waterItemQueue.add(sparklingWater);

        Queue<Item> cocaColaItemQueue = new ArrayDeque<Item>();
        cocaColaItemQueue.add(cocaCola);
        cocaColaItemQueue.add(cocaCola);
        cocaColaItemQueue.add(cocaCola);

        Map<Integer, Queue<Item>> storageMap = new HashMap<Integer, Queue<Item>>();

        storageMap.put(22, chocolateItemQueue);
        storageMap.put(23, waterItemQueue);
        storageMap.put(24, cocaColaItemQueue);

        VendingStorage vendingStorage = new VendingStorage(storageMap);
        System.out.println(vendingStorage);

        Bank bank = new Bank();
        Queue<Coin> oneDollars = new ArrayDeque<>();
        oneDollars.add(Coin.ONE_DOLLAR);
        oneDollars.add(Coin.ONE_DOLLAR);
        oneDollars.add(Coin.ONE_DOLLAR);

        Queue<Coin> dimes = new ArrayDeque<>();
        dimes.add(Coin.DIME);

        Queue<Coin> halfs = new ArrayDeque<>();
        halfs.add(Coin.HALF);
        halfs.add(Coin.HALF);

        Queue<Coin> penny = new ArrayDeque<>();
        penny.add(Coin.PENNY);
        penny.add(Coin.PENNY);
        penny.add(Coin.PENNY);

        Queue<Coin> quarters = new ArrayDeque<>();
        quarters.add(Coin.QUARTER);
        quarters.add(Coin.QUARTER);

        Queue<Coin> nickles = new ArrayDeque<>();
        nickles.add(Coin.NICKLE);
        nickles.add(Coin.NICKLE);

        bank.setOneDollarStack(oneDollars);
        bank.setDimeStack(dimes);
        bank.setHalfStack(halfs);
        bank.setPennyStack(penny);
        bank.setQuarterStack(quarters);
        bank.setNickelStack(nickles);

        System.out.println(bank);

        VendingMachineImpl vendingMachine = new VendingMachineImpl(vendingStorage, bank);

        System.out.println(vendingMachine.getItem(22));

        System.out.println(vendingStorage);

        boolean isFullyPaid = vendingMachine.payItem(23, oneDollars);
        System.out.println("is fully paid = " + isFullyPaid);
    }
}
