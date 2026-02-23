package state;

import model.VendingMachine;

public class IdleState implements VendingMachineState {

    @Override
    public void selectItem(VendingMachine machine, String item) {
        if (!machine.hasItem(item)) {
            System.out.println("Item not available.");
            return;
        }

        machine.setSelectedItem(item);
        System.out.println("Item selected: " + item);
        machine.setState(new ItemSelectedState());
    }

    @Override
    public void insertCoin(VendingMachine machine, double amount) {
        System.out.println("Insert coin not allowed. Select item first.");
    }

    @Override
    public void dispenseItem(VendingMachine machine) {
        System.out.println("Cannot dispense. No item selected.");
    }

    @Override
    public void setOutOfOrder(VendingMachine machine) {
        machine.setState(new OutOfOrderState());
        System.out.println("Machine is now OUT OF ORDER.");
    }
}