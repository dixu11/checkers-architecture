package pl.dixu.checkersarchitecture.adapters;

import org.springframework.stereotype.Component;
import pl.dixu.checkersarchitecture.useCase.UseCaseInteractor;
import pl.dixu.checkersarchitecture.entity.MoveEvent;

@Component
public class Controller {

    private UseCaseInteractor useCaseInteractor;

    public Controller(UseCaseInteractor useCaseInteractor) {
        this.useCaseInteractor = useCaseInteractor;
    }

    public void startGame() {
        useCaseInteractor.startGame();
    }

    public void move(MoveEvent moveEvent) {
        useCaseInteractor.move(moveEvent);
    }
}
