package pl.dixu.checkersarchitecture.entity;

enum  MoveValidationStatus {
    OUTSIDE_BOARD(false),
    NO_CHECKER(false),
    NOT_YOUR_CHECKER(false),
    NOT_VALID_MOVE(false),
    FIELD_BLOCKED(false),
    MOVE(true),
    ATTACK(true),
    PROMOTION(true),
    NO_STATUS(false);

    private boolean valid;

    MoveValidationStatus(boolean valid) {
        this.valid = valid;
    }

    public boolean isValid() {
        return valid;
    }
}
