package state;

import model.VendingMachine;

public class OutOfOrderState implements VendingMachineState {

    @Override
    public void selectItem(VendingMachine machine, String item) {
        System.out.println("Machine out of order.");
    }

    @Override
    public void insertCoin(VendingMachine machine, double amount) {
        System.out.println("Machine out of order.");
    }

    @Override
    public void dispenseItem(VendingMachine machine) {
        System.out.println("Machine out of order.");
    }

    @Override
    public void setOutOfOrder(VendingMachine machine) {
        System.out.println("Already out of order.");
    }
}