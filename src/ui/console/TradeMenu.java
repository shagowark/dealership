package ui.console;

import java.util.Scanner;

public class TradeMenu {
    private final Scanner input;

    public TradeMenu(Scanner input) {
        this.input = input;
    }

    public void runTradeMenu(){
        showTradeMenu();
        checkInputTradeMenu();
    }

    private void showTradeMenu(){
        System.out.println(
                """
                
                """
        );
    }

    private void checkInputTradeMenu(){

    }
}
