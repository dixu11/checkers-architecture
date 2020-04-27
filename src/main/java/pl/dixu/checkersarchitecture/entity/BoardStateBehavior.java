package pl.dixu.checkersarchitecture.entity;

import java.util.HashSet;
import java.util.Set;

class BoardStateBehavior {

    private BoardState boardState;

    public BoardStateBehavior(BoardState boardState) {
        this.boardState = boardState;
    }

    public BoardState executeMove(MoveEvent moveEvent) {
        Set<CheckerData> checkers = new HashSet<>(boardState.getCheckers());

        CheckerData checker =
                boardState.findCheckerOrThrow(moveEvent.getFromRow(), moveEvent.getFromColumn());
        checkers.remove(checker);
        checkers.add(new CheckerData(moveEvent.getToRow(), moveEvent.getToColumn(), checker.getColor()));
        return new BoardState(checkers, boardState.getActualPlayer().nextColor());
    }
}
