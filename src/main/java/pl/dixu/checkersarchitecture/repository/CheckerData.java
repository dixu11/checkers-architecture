package pl.dixu.checkersarchitecture.repository;

import pl.dixu.checkersarchitecture.interaction.Color;

import java.util.Objects;

public class CheckerData {
    private int row;
    private int col;
    private Color color;

    public CheckerData(int row, int col, Color color) {
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
        CheckerData that = (CheckerData) o;
        return row == that.row &&
                col == that.col &&
                color == that.color;
    }

    @Override
    public int hashCode() {
        return Objects.hash(row, col, color);
    }
}
