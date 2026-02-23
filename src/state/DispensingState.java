package state;

import model.VendingMachine;

public class DispensingState implements VendingMachineState {

    @Override
    public void selectItem(VendingMachine machine, String item) {
        System.out.println("Currently dispensing. Please wait.");
    }

    @Override
    public void insertCoin(VendingMachine machine, double amount) {
        System.out.println("Currently dispensing. Cannot insert coin.");
    }

    @Override
    public void dispenseItem(VendingMachine machine) {

        String item = machine.getSelectedItem();

        if (item == null) {
            System.out.println("No item to dispense.");
            machine.setState(new IdleState());
            return;
        }

        machine.releaseItem(item);
        machine.resetBalance();

        System.out.println("Dispensing: " + item);

        // Automatically return to Idle
        machine.setState(new IdleState());
    }

    @Override
    public void setOutOfOrder(VendingMachine machine) {
        machine.setState(new OutOfOrderState());
    }
}