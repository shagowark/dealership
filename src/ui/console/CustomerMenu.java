package ui.console;

import java.util.Scanner;

public class CustomerMenu {
    private final Scanner input;

    public CustomerMenu(Scanner input) {
        this.input = input;
    }

    public void runCustomerMenu(){
        showCustomerMenu();
        checkInputCustomerMenu();
    }

    private void showCustomerMenu(){
        System.out.println(
                """
                """
        );
    }

    private void checkInputCustomerMenu(){

    }
}
