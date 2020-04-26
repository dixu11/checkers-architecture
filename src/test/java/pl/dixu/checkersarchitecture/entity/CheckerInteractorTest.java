package pl.dixu.checkersarchitecture.entity;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CheckerInteractorTest {

    private CheckerInteractor interactor = new CheckerInteractor();
    private CheckerFactory factory = new CheckerFactoryWhiteFirst();

    @Test
    void move_should_return_correct_new_state_for_correct_move() {
        //given
        BoardState boardState = factory.buildStartingBoardState();
        MoveEvent moveEvent = new MoveEvent(2, 1, 3, 0, Color.WHITE);

        //when
        MoveResult actualResult = interactor.move(moveEvent, boardState);

        //than
        assertTrue(actualResult.wasExecuted());
        assertTrue(actualResult.hasCheckerOnField(3,0));
    }
}