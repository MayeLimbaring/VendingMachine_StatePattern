import model.VendingMachine;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        VendingMachine vm = new VendingMachine();

        while (true) {

            System.out.println("\n==== VENDING MACHINE ====");
            System.out.println("1. Select Item");
            System.out.println("2. Insert Coin");
            System.out.println("3. Dispense Item");
            System.out.println("4. Set Out Of Order");
            System.out.println("5. Exit");
            System.out.print("Choose: ");

            int choice = sc.nextInt();
            sc.nextLine(); // consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter item name: ");
                    String item = sc.nextLine();
                    vm.selectItem(item);
                    break;

                case 2:
                    System.out.print("Enter amount: ");
                    double amt = sc.nextDouble();
                    vm.insertCoin(amt);
                    break;

                case 3:
                    vm.dispenseItem();
                    break;

                case 4:
                    vm.setOutOfOrder();
                    break;

                case 5:
                    System.out.println("Exiting...");
                    return;

                default:
                    System.out.println("Invalid choice.");
            }
        }
    }
}