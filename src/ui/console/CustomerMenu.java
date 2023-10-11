package ui.console;

import controllers.CustomerController;

import java.util.Scanner;

public class CustomerMenu {
    private final Scanner input;

    //TODO singleton for cntrlr
    private final CustomerController customerController = CustomerController.getInstance();
    private boolean running = true;

    public CustomerMenu(Scanner input) {
        this.input = input;
    }

    public void runCustomerMenu() {
        while (running) {
            showCustomerMenu();
            checkInputCustomerMenu();
        }
    }

    private void showCustomerMenu() {
        System.out.println(
                """
                                        
                        ***Клиенты***
                        1 - показать всех клиентов
                        2 - добавить клиента
                        3 - удалить клиента
                        4 - редактировать клиента
                        x - в главное меню
                        """
        );
    }

    private void checkInputCustomerMenu() {
        switch (input.next()) {
            case "1" -> listAllCustomers();
            case "2" -> saveCustomer();
            case "3" -> removeCustomer();
            case "4" -> updateCustomer();
            case "x" -> {
                System.out.println("Возвращение...");
                running = false;
            }
            default -> System.out.println("Неверный ввод");
        }
    }

    private void listAllCustomers() {
        for (String str : customerController.listAllCustomers()) {
            System.out.println(str);
        }
    }

    private void saveCustomer() {
        try {
            System.out.println("Введите данные клиента:");
            input.nextLine();
            customerController.saveCustomer(input.nextLine());
            System.out.println("Успешно!");
        } catch (Exception e) {
            System.out.println("Неверный ввод!");
        }
    }

    private void removeCustomer() {
        try {
            System.out.println("Введите ID клиента, который хотите удалить");
            customerController.removeCustomerById(input.nextInt());
            System.out.println("Успешно");
        } catch (Exception e) {
            System.out.println("Неверный ввод!");
        }
    }

    private void updateCustomer() {
        try {
            System.out.println("Введите актуальную информацию о клиенте (вместе с ID)");
            input.nextLine();
            customerController.updateCustomer(input.nextLine());
        } catch (Exception e) {
            System.out.println("Неверный ввод!");
        }
    }
}
