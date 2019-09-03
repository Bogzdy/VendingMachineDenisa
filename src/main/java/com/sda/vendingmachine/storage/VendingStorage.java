package com.sda.vendingmachine.storage;

import com.sda.vendingmachine.bank.Coin;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Map;
import java.util.Queue;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class VendingStorage {
    Map<Integer, Queue<Item>> storageMap;

    @Override
    public String toString() {
        String toReturn = "";

        for (Map.Entry<Integer, Queue<Item>> entry: storageMap.entrySet()){
            toReturn = toReturn.concat("Tasta " + entry.getKey() + " " +
                    entry.getValue().peek().toString() + " cantitatea " +
                    entry.getValue().size()) + "\n";
        }
        return toReturn;

    }
}
