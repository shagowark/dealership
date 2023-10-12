package ui.console;

import controllers.CustomerController;

import java.util.Scanner;

public class CustomerMenu implements Command{
    private final Scanner input;
    private final CustomerController customerController = CustomerController.getInstance();
    private boolean running;

    public CustomerMenu(Scanner input) {
        this.input = input;
    }

    @Override
    public void execute() {
        running = true;
        while (running) {
            showCustomerMenu();
            checkInputCustomerMenu();
        }
    }

    @Override
    public String getMessage() {
        return "2 - Меню покупатели";
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
        System.out.println("ID  Фамилия  Имя  Отчество  Возраст Пол");
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
