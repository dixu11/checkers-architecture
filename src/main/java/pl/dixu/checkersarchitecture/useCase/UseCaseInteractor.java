package pl.dixu.checkersarchitecture.useCase;

import org.springframework.stereotype.Component;
import pl.dixu.checkersarchitecture.entity.*;
import pl.dixu.checkersarchitecture.entity.CheckerData;

import java.util.Set;
//główna klasa warstwy przypadków użycia z metodami niezależnych przypadków  interakcji z grą
@Component
public  class UseCaseInteractor {

    //old
    private GameInitializer initializer;
    private InformerFacade informer;
    private Executor executor;

    private DataAccess dataAccess;
    private CheckerGame checkerGame;



    public UseCaseInteractor(GameInitializer initializer, InformerFacade informer, Executor executor) {
        this.initializer = initializer;
        this.informer = informer;
        this.executor = executor;
    }
//pobieranie aktualnego stanu gry zwraca immutable strukturę danych określających pola i stojące na nich figury
    public Set<FieldStateData> getBoardState() {
        Set<CheckerData> checkers = dataAccess.getCheckers();
        return checkerGame.getBoardState(checkers);
    }

    public void startGame() {
        initializer.startGame();
    }

    public void move(MoveEvent moveEvent) {
        executor.move(moveEvent);
    }
}
