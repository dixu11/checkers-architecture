package pl.dixu.checkersarchitecture.console.client;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class Runner implements ApplicationRunner {

    private Updater updater;

    public Runner(Updater updater) {
        this.updater = updater;
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        updater.startGame();
        updater.printBoard();

    }
}
