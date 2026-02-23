package state;

import model.VendingMachine;

public class ItemSelectedState implements VendingMachineState {

    @Override
    public void selectItem(VendingMachine machine, String item) {
        System.out.println("Item already selected. Cannot select again.");
    }

    @Override
    public void insertCoin(VendingMachine machine, double amount) {
        machine.addBalance(amount);
        System.out.println("Inserted: " + amount);

        if (machine.hasEnoughBalance()) {
            machine.setState(new DispensingState());
            machine.dispenseItem();
        }
    }

    @Override
    public void dispenseItem(VendingMachine machine) {
        if (!machine.hasEnoughBalance()) {
            System.out.println("Not enough balance.");
            return;
        }

        machine.setState(new DispensingState());
        machine.dispenseItem();
    }

    @Override
    public void setOutOfOrder(VendingMachine machine) {
        machine.setState(new OutOfOrderState());
        System.out.println("Machine is now OUT OF ORDER.");
    }
}