package ui.console;

import java.util.Scanner;

public class MainMenu {
    private final Scanner input;

    private final CarMenu carMenu;
    private final CustomerMenu customerMenu;
    private final TradeMenu tradeMenu;

    private boolean running = true;

    public MainMenu(Scanner input, CarMenu carMenu, CustomerMenu customerMenu, TradeMenu tradeMenu) {
        this.input = input;
        this.carMenu = carMenu;
        this.customerMenu = customerMenu;
        this.tradeMenu = tradeMenu;
    }

    public void runMainMenu(){
        while (running) {
            showMainMenu();
            checkInputMainMenu();
        }
    }

    private void showMainMenu(){
        System.out.println(
                """
                
                ***Автосалон***
                1 - меню автомобили
                2 - меню покупатели
                3 - меню продажи
                x - завершить работу
                """
        );
    }

    private void checkInputMainMenu(){
        switch (input.next()){
            case "1" -> carMenu.runCarMenu();
            case "2" -> customerMenu.runCustomerMenu();
            case "3" -> tradeMenu.runTradeMenu();
            case "x" -> {
                System.out.println("Завершение работы");
                running = false;
            }
        }
    }
}
