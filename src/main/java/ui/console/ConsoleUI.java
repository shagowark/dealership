package ui.console;

import java.util.Scanner;

public class ConsoleUI {
    private final Scanner input = new Scanner(System.in);
    private final CarMenu carMenu = new CarMenu(input);
    private final CustomerMenu customerMenu = new CustomerMenu(input);
    private final TradeMenu tradeMenu = new TradeMenu(input);
    private final MainMenu mainMenu = new MainMenu(input, carMenu, customerMenu, tradeMenu);
    public void start(){
        run();
    }

    private void run(){
        mainMenu.runMainMenu();
    }


}
