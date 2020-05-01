package pl.dixu.checkersarchitecture.entity;

import org.springframework.stereotype.Component;

//entity component for moving pieces
@Component
class CheckerInteractor {

    private BoardState boardState;
    private MoveEvent moveEvent;

    MoveResult move(MoveEvent moveEvent, BoardState boardState) {
        attachProcessedData(moveEvent, boardState);
        MoveAnalizator analizator = new MoveAnalizator(moveEvent, boardState);
        analizator.analizeMove();
        return executeMoveIfValid(analizator);
    }

    private void attachProcessedData(MoveEvent moveEvent, BoardState boardState) {
        this.boardState = boardState;
        this.moveEvent = moveEvent;
    }

    private MoveResult executeMoveIfValid(MoveAnalizator analizator) {
        if (analizator.isMoveValid()) {
            BoardState newBoardState = executeMove(analizator);
            return new MoveResult(newBoardState, true, analizator.getValidationStatus());
        }
        return new MoveResult(boardState, false, analizator.getValidationStatus());
    }

    private BoardState executeMove(MoveAnalizator analizator) {
        BoardStateBehavior board = new BoardStateBehavior(boardState);
        if (analizator.getMoveType() == MoveType.STEP) {
            return board.executeMove(moveEvent);
        }
        return boardState;
    }
}
