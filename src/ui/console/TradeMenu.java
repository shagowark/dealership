package ui.console;

import controllers.TradeController;

import java.util.Scanner;

public class TradeMenu {
    private final Scanner input;
    private TradeController tradeController = new TradeController();
    private boolean running = true;

    public TradeMenu(Scanner input) {
        this.input = input;
    }

    public void runTradeMenu(){
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
        }
    }

    private void listAllTrades() {
        for (String str : tradeController.listAllTrades()){
            System.out.println(str);
        }
    }
}
