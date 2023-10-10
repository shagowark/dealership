package ui.console;

import controllers.CarController;

import java.util.Scanner;

public class CarMenu {
    private final CarController carController = new CarController();
    private final Scanner input;
    private boolean running = true;

    public CarMenu(Scanner input) {
        this.input = input;
    }

    public void runCarMenu(){
        while (running) {
            showCarMenu();
            checkInputCarMenu();
        }
    }

    private void showCarMenu(){
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


    private void checkInputCarMenu(){
        switch (input.next()){
            case "1" -> listAllCars();
            case "2" -> saveCar();
            case "3" -> removeCar();
            case "4" -> updateCar();
            // TODO продажа авто
            case "x" -> {
                System.out.println("Возвращение...");
                running = false;
            }
        }
    }

    private void listAllCars(){
        for (String str : carController.listAllCars()){
            System.out.println(str);
        }
    }

    private void saveCar(){
        System.out.println("Введите данные автомобиля:");
        input.nextLine();
        carController.saveCar(input.nextLine());
        System.out.println("Успешно!");
    }

    private void removeCar(){
        System.out.println("Введите ID автомобиля, который хотите удалить");
        carController.removeCarById(input.nextInt()); //TODO где поставить проверку??
        System.out.println("Успешно");
    }

    private void updateCar(){
        System.out.println("Введите актуальную информацию о машине (вместе с ID)");
        input.nextLine();
        carController.updateCar(input.nextLine());
    }
}
