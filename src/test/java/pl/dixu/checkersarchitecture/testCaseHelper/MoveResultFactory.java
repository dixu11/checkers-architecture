package pl.dixu.checkersarchitecture.testCaseHelper;

import pl.dixu.checkersarchitecture.entity.MoveResult;
import pl.dixu.checkersarchitecture.entity.MoveValidationStatus;

import static pl.dixu.checkersarchitecture.entity.MoveValidationStatus.*;

public class MoveResultFactory {

    public static MoveResult moveOutsideBoard() {
        return getMoveResultWithStatus(OUTSIDE_BOARD,false);
    }

    public static MoveResult moveWithNoCheckerSelected() {
        return getMoveResultWithStatus(NO_CHECKER,false);
    }

    public static MoveResult moveWithNotYourCheckerSelected() {
        return getMoveResultWithStatus(NOT_YOUR_CHECKER, false);
    }

    private static MoveResult getMoveResultWithStatus(MoveValidationStatus status, boolean executed) {
        return new MoveResult(BoardStateFactory.boardWithOneWhiteChecker(),
                executed,
                status);
    }

    public static MoveResult notValidMove() {
        return getMoveResultWithStatus(NOT_VALID_MOVE, false);
    }

    public static MoveResult moveOnBlockedField() {
        return getMoveResultWithStatus(FIELD_BLOCKED, false);
    }

    public static MoveResult moveWithNoStatus() {
        return getMoveResultWithStatus(NO_STATUS, false);
    }

    public static MoveResult correctMove() {
        return getMoveResultWithStatus(MOVE, true);
    }
}
