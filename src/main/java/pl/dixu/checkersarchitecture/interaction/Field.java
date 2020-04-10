package pl.dixu.checkersarchitecture.interaction;

import java.util.Objects;

public class Field {
    private final int row;
    private final int col;
    private final Color color;

    public Field(int row, int col, Color color) {
        this.row = row;
        this.col = col;
        this.color = color;
    }

    public int getRow() {
        return row;
    }

    public int getCol() {
        return col;
    }

    public Color getColor() {
        return color;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Field field = (Field) o;
        return row == field.row &&
                col == field.col;
    }

    @Override
    public int hashCode() {
        return Objects.hash(row, col);
    }
}
