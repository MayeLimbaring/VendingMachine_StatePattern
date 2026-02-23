package model;

import state.*;

import java.util.HashMap;
import java.util.Map;

public class VendingMachine {

    private VendingMachineState currentState;
    private Map<String, Integer> inventory;
    private double balance;
    private String selectedItem;

    private final double ITEM_PRICE = 20.0;

    public VendingMachine() {
        inventory = new HashMap<>();
        inventory.put("Soda", 5);
        inventory.put("Chips", 3);
        inventory.put("Candy", 2);

        currentState = new IdleState();
        balance = 0;
    }

    // --- Delegation methods ---
    public void selectItem(String item) {
        currentState.selectItem(this, item);
    }

    public void insertCoin(double amount) {
        currentState.insertCoin(this, amount);
    }

    public void dispenseItem() {
        currentState.dispenseItem(this);
    }

    public void setOutOfOrder() {
        currentState.setOutOfOrder(this);
    }

    // --- Helper methods ---
    public boolean hasItem(String item) {
        return inventory.containsKey(item) && inventory.get(item) > 0;
    }

    public void releaseItem(String item) {
        inventory.put(item, inventory.get(item) - 1);
        selectedItem = null;
    }

    public void addBalance(double amount) {
        balance += amount;
    }

    public boolean hasEnoughBalance() {
        return balance >= ITEM_PRICE;
    }

    public void resetBalance() {
        balance = 0;
    }

    // --- Getters/Setters ---
    public void setState(VendingMachineState state) {
        this.currentState = state;
    }

    public void setSelectedItem(String item) {
        this.selectedItem = item;
    }

    public String getSelectedItem() {
        return selectedItem;
    }
}