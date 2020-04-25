package pl.dixu.checkersarchitecture.console.adapters;

import org.springframework.stereotype.Component;
import pl.dixu.checkersarchitecture.entity.FieldStateData;
import pl.dixu.checkersarchitecture.useCase.UseCaseInteractor;
import pl.dixu.checkersarchitecture.entity.MoveEvent;

import java.util.Set;

@Component
public class Controller {

    private UseCaseInteractor useCaseInteractor;


    public Controller(UseCaseInteractor useCaseInteractor) {
        this.useCaseInteractor = useCaseInteractor;
    }

    public Set<FieldStateData> getBoardState() {
        return useCaseInteractor.getBoardState();
    }

    public void startGame() {
        useCaseInteractor.startGame();
    }

    public void move(MoveEvent moveEvent) {
        useCaseInteractor.move(moveEvent);
    }
}
