package pl.dixu.checkersarchitecture.client;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;
import pl.dixu.checkersarchitecture.adapters.Controller;
import pl.dixu.checkersarchitecture.entity.MoveEvent;

import java.util.Scanner;

@Component
class Runner implements ApplicationRunner {

    private Controller controller;

    public Runner(Controller controller) {
        this.controller = controller;
    }

    @Override
    public void run(ApplicationArguments args) {
        controller.startGame();
        executeTurn();
    }

    private void executeTurn() {
        while (true) {
            executeMove();
        }
    }

    private void executeMove() {
        MoveEvent moveEvent = askForMove();
        controller.move(moveEvent);
    }

    private MoveEvent askForMove() {
        System.out.println("Which checker would you like to move?");
        int[] selected = askForCords();
        System.out.println("Where would you like to move?");
        int[] destination = askForCords();
        return prepareMoveEventFor(selected, destination);
    }

    private MoveEvent prepareMoveEventFor(int[] selected, int[] destination) {
        InputToIndexTranslator translator = new InputToIndexTranslator();
        return new MoveEvent(
                translator.translateInputRowToIndex(selected[0]),
                translator.translateInputColToIndex(selected[1]),
                translator.translateInputRowToIndex(destination[0]),
                translator.translateInputColToIndex(destination[1])
        );
    }

    private int[] askForCords(){
        Scanner in = new Scanner(System.in);
        System.out.println("Type row nr:");
        int row = in.nextInt();
        System.out.println("Type col nr:");
        int col = in.nextInt();
        return new int[]{row, col};
    }
}
