package ui.console;

import controllers.CarController;

import java.util.Scanner;

public class CarMenu implements Command{
    private final CarController carController = CarController.getInstance();
    private final Scanner input;
    private boolean running;

    public CarMenu(Scanner input) {
        this.input = input;
    }

    @Override
    public void execute() {
        running = true;
        while (running) {
            showCarMenu();
            checkInputCarMenu();
        }
    }

    @Override
    public String getMessage(){
        return "1 - Меню автомобили";
    }

    private void showCarMenu() {
        System.out.println(
                """
                                        
                        ***Автомобили***
                        1 - показать все машины
                        2 - добавить машину
                        3 - удалить машину
                        4 - редактировать машину
                        5 - купить машину
                        x - в главное меню
                        """);
    }


    private void checkInputCarMenu() {
        switch (input.next()) {
            case "1" -> listAllCars();
            case "2" -> saveCar();
            case "3" -> removeCar();
            case "4" -> updateCar();
            case "5" -> sellCar();
            case "x" -> {
                System.out.println("Возвращение...");
                running = false;
            }
            default -> System.out.println("Неверный ввод!");
        }
    }

    private void listAllCars() {
        System.out.println("ID  Тип  Марка  Модель");
        for (String str : carController.listAllCars()) {
            System.out.println(str);
        }
    }

    private void saveCar() {
        try {
            System.out.println("Введите данные автомобиля:");
            input.nextLine();
            carController.saveCar(input.nextLine());
            System.out.println("Успешно!");
        } catch (Exception e) {
            System.out.println("Неверный ввод!");
        }
    }

    private void removeCar() {
        try {
            System.out.println("Введите ID автомобиля, который хотите удалить");
            carController.removeCarById(input.nextInt());
            System.out.println("Успешно");
        } catch (Exception e) {
            System.out.println("Неверный ввод!");
        }
    }

    private void updateCar() {
        try {
            System.out.println("Введите актуальную информацию об автомобиле (вместе с ID)");
            input.nextLine();
            carController.updateCar(input.nextLine());
            System.out.println("Успешно");
        } catch (Exception e) {
            System.out.println("Неверный ввод!");
        }
    }

    private void sellCar() {
        try {
            System.out.println("Введите ID продаваемого автомобиля");
            int id = input.nextInt();
            System.out.println("Введите информацию о покупателе");
            input.nextLine();
            String customerStr = input.nextLine();
            carController.sellCar(id, customerStr);
            System.out.println("Успешно");
        } catch (Exception e) {
            System.out.println("Неверный ввод!");
        }
    }
}
