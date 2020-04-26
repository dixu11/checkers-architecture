package pl.dixu.checkersarchitecture.entity;

import org.springframework.stereotype.Component;

//entity component for moving pieces
@Component
public class CheckerInteractor {

    private BoardState boardState;
    private MoveEvent moveEvent;


    public MoveResult move(MoveEvent moveEvent, BoardState boardState) {
        MoveValidationStatus status = validateMove();
        if (status.isValid()) {

        }
        return null;
    }

    private MoveValidationStatus validateMove() {
        if (isOutsideBoard()) {

        }
        return null;
    }

    private boolean isOutsideBoard() {
        return false;
    }

    private void setMoveData(MoveEvent moveEvent, BoardState boardState) {
        this.boardState = boardState;
        this.moveEvent = moveEvent;
    }

    private boolean isCorrectCheckerSelected() {

    }

}
