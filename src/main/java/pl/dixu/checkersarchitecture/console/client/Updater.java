package pl.dixu.checkersarchitecture.console.client;

import org.springframework.stereotype.Component;
import pl.dixu.checkersarchitecture.console.printer.BoardPrintingHandler;
import pl.dixu.checkersarchitecture.console.printer.PrinterException;
import pl.dixu.checkersarchitecture.controller.Controller;

@Component
public class Updater {

    private Controller controller;
    private BoardPrintingHandler printer;

    public Updater(Controller controller, BoardPrintingHandler printer) {
        this.controller = controller;
        this.printer = printer;
    }


    public void startGame() {
        controller.startGame();
    }

    public void printBoard() {
        handlePrintBoard();
    }

    private void handlePrintBoard() {
        try {
            printer.printBoard(controller.getBoardState());
        } catch (PrinterException e) {
            System.err.println(e.getMessage());
        }
    }


}
