package pl.dixu.checkersarchitecture.entity;

class MoveAnalizator {

    private MoveEvent moveEvent;
    private BoardState boardState;
    private MoveValidationStatus validationStatus = MoveValidationStatus.NO_STATUS;
    private MoveType moveType = MoveType.INVALID;

    public MoveAnalizator(MoveEvent moveEvent, BoardState boardState) {
        this.moveEvent = moveEvent;
        this.boardState = boardState;
    }

    public void analizeMove() {
        validationStatus = validateMove();
        if (!validationStatus.isValid()) {
            return;
        }
        moveType = computeMoveType();
    }

    private MoveValidationStatus validateMove() {
        if (!cordsAreInsideBoard()) {
            return MoveValidationStatus.OUTSIDE_BOARD;
        }
        if (!hasChecker()) {
            return MoveValidationStatus.NO_CHECKER;
        }
        CheckerData selected = getSelectedChecker();
        if (selected.getColor() != boardState.getActualPlayer()) {
            return MoveValidationStatus.NOT_YOUR_CHECKER;
        }
        MoveType moveType = computeMoveType();
        if (moveType == MoveType.INVALID) {
            return MoveValidationStatus.NOT_VALID_MOVE;
        }
        if (isCheckerOnToField() || moveType != MoveType.STEP) {
            return MoveValidationStatus.FIELD_BLOCKED;
        }
        return MoveValidationStatus.MOVE;
    }

    private MoveType computeMoveType() {
        CheckerData selected = getSelectedChecker();
        CheckerBehavior checkerBehavior = new CheckerBehavior(selected);
        return checkerBehavior.getMoveType(moveEvent.getToRow(), moveEvent.getToColumn());
    }

    private boolean cordsAreInsideBoard() {
        return BoardProperties.isRowIndexInRange(moveEvent.getFromRow()) &&
                BoardProperties.isRowIndexInRange(moveEvent.getToRow()) &&
                BoardProperties.isColIndexInRange(moveEvent.getFromColumn()) &&
                BoardProperties.isColIndexInRange(moveEvent.getToColumn());
    }

    private boolean hasChecker() {
        return boardState.hasChecker(moveEvent.getFromRow(), moveEvent.getFromColumn());
    }

    private boolean isCheckerOnToField() {
        return boardState.hasChecker(moveEvent.getToRow(),moveEvent.getToColumn());
    }



    private CheckerData getSelectedChecker() {
        return boardState.findChecker(moveEvent.getFromRow(), moveEvent.getFromColumn())
                .orElseThrow();
    }

    public MoveValidationStatus getValidationStatus() {
        return validationStatus;
    }

    public MoveType getMoveType() {
        return moveType;
    }
}
