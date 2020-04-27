package pl.dixu.checkersarchitecture.entity;

import org.springframework.stereotype.Component;

//entity component for moving pieces
@Component
class CheckerInteractor {

    private BoardState boardState;
    private MoveEvent moveEvent;


    public MoveResult move(MoveEvent moveEvent, BoardState boardState) {
        this.boardState = boardState;
        this.moveEvent = moveEvent;
        MoveAnalizator analizator = new MoveAnalizator(moveEvent,boardState);
       analizator.analizeMove();
        if (analizator.getValidationStatus().isValid()) {//todo
            BoardState newBoardState = executeMove(analizator);
            return new MoveResult(newBoardState, true);
        }
        return null;
    }

    public BoardState executeMove(MoveAnalizator analizator) {
        BoardStateBehavior board = new BoardStateBehavior(boardState);
        if (analizator.getMoveType() == MoveType.STEP) {
            return board.executeMove(moveEvent);
        }
        return boardState;
    }



}
