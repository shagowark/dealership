package ui.console;

import controllers.TradeController;

import java.util.Scanner;

public class TradeMenu {
    private final Scanner input;
    private final TradeController tradeController = TradeController.getInstance();
    private boolean running;

    public TradeMenu(Scanner input) {
        this.input = input;
    }

    public void runTradeMenu(){
        running = true;
        while (running){
            showTradeMenu();
            checkInputTradeMenu();
        }
    }

    private void showTradeMenu(){
        System.out.println(
                """
                
                ***Продажи***
                1 - показать все продажи
                x - назад
                """
        );
    }

    private void checkInputTradeMenu(){
        switch (input.next()){
            case "1" -> listAllTrades();
            case "x" -> {
                System.out.println("Возвращение...");
                running = false;
            }
            default -> System.out.println("Неверный ввод!");
        }
    }

    private void listAllTrades() {
        System.out.println("ID  ID_машины  ID_покупателя");
        for (String str : tradeController.listAllTrades()){
            System.out.println(str);
        }
    }
}
