package pl.dixu.checkersarchitecture.entity;

//result of checker move, contains info about effect and new state
public class MoveResult {

    private BoardState boardState;
    private boolean wasExecuted;

    public MoveResult(BoardState boardState, boolean wasExecuted) {
        this.boardState = boardState;
        this.wasExecuted = wasExecuted;
    }

    public boolean wasExecuted() {
        return wasExecuted;
    }

    public boolean hasCheckerOnField(int row, int col) {
        return boardState.hasChecker(row, col);
    }

    public BoardState getBoardState() {
        return boardState;
    }
}
