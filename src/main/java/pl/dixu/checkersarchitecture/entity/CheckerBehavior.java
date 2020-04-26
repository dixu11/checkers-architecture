package pl.dixu.checkersarchitecture.entity;

import static java.lang.Math.abs;

public class CheckerBehavior {
    private CheckerData checker;

    public CheckerBehavior(CheckerData checker) {
        this.checker = checker;
    }

    public MoveType getMoveType(int row, int col) {
        int absDistance = abs(checker.getRow() -row) + abs(checker.getCol()-col);
        if (absDistance == 2) {
            return MoveType.STEP;
        } else if (absDistance == 4) {
            return MoveType.ONE_ATTACK;
        }
        return MoveType.INVALID;
    }

}
