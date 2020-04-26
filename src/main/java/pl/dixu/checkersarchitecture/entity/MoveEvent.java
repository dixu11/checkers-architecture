package pl.dixu.checkersarchitecture.entity;

public class MoveEvent {
    private final int fromRow;
    private final int fromColumn;
    private final int toRow;
    private final int toColumn;
    private final Color color;

    public MoveEvent(int fromRow, int fromColumn, int toRow, int toColumn, Color color) {
        this.fromRow = fromRow;
        this.fromColumn = fromColumn;
        this.toRow = toRow;
        this.toColumn = toColumn;
        this.color = color;
    }

    public int getFromRow() {
        return fromRow;
    }

    public int getFromColumn() {
        return fromColumn;
    }

    public int getToRow() {
        return toRow;
    }

    public int getToColumn() {
        return toColumn;
    }
}
