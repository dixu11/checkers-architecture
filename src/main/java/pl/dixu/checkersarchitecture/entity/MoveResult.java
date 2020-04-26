package pl.dixu.checkersarchitecture.entity;

//result of checker move, contains info about effect and new state
public class MoveResult {
    public boolean wasExecuted() {
        return false;
    }

    public boolean hasCheckerOnField(int row, int col) {
        return false;
    }

    public BoardState getBoardState() {
        return null;
    }
}
