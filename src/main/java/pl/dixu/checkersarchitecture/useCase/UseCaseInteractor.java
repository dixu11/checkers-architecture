package pl.dixu.checkersarchitecture.useCase;

import org.springframework.stereotype.Component;
import pl.dixu.checkersarchitecture.adapters.Presenter;
import pl.dixu.checkersarchitecture.entity.*;

//główna klasa warstwy przypadków użycia z metodami niezależnych przypadków  interakcji z grą
@Component
public  class UseCaseInteractor {
    private DataAccess dataAccess;
    private CheckerGame checkerGame;
    private Presenter presenter;

    public UseCaseInteractor(CheckerGame checkerGame, DataAccess dataAccess, Presenter presenter) {
        this.checkerGame = checkerGame;
        this.dataAccess = dataAccess;
        this.presenter = presenter;
    }
//pobieranie aktualnego stanu gry zwraca immutable strukturę danych określających pola i stojące na nich figury
    public void startGame() {
        BoardState startingBoardState = checkerGame.getStartingBoard();
        dataAccess.save(startingBoardState);
    }

    public void printBoard() {
        presenter.showBoard(getBoardState());
    }

    public void move(MoveEvent moveEvent) {
        MoveResult moveResult = checkerGame.move(moveEvent, getBoardState());
        if (moveResult.wasExecuted()) {
            dataAccess.save(moveResult.getBoardState());
        }
        presenter.showMove(moveResult);
    }

    private BoardState getBoardState() {
        return dataAccess.getBoardState();
    }
}

