package pl.dixu.checkersarchitecture.runners;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;
import pl.dixu.checkersarchitecture.adapters.Controller;
import pl.dixu.checkersarchitecture.client.ConsolePresenter;
import pl.dixu.checkersarchitecture.entity.Color;
import pl.dixu.checkersarchitecture.entity.MoveEvent;

@Component
public class Runner implements ApplicationRunner {

    private Controller controller;

    public Runner(Controller controller) {
        this.controller = controller;
    }

    @Override
    public void run(ApplicationArguments args)  {
        controller.startGame();
        controller.printBoard();
        controller.move(new MoveEvent(2,1,3,0, Color.WHITE));
    }
}
