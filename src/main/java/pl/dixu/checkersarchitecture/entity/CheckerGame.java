package pl.dixu.checkersarchitecture.entity;

import org.springframework.stereotype.Component;

//fasada warsty entity
@Component
public class CheckerGame {

    private CheckerFactory checkerFactory;
    private CheckerInteractor manipulator;

    public CheckerGame( CheckerFactory checkerFactory, CheckerInteractor manipulator) {
        this.checkerFactory = checkerFactory;
        this.manipulator = manipulator;
    }

    public BoardState getStartingBoard() {
       return checkerFactory.buildStartingBoardState();
    }

    public MoveResult move(MoveEvent moveEvent, BoardState boardState) {
        return manipulator.move(moveEvent, boardState);
    }
}
