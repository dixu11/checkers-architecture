package pl.dixu.checkersarchitecture.client;

import pl.dixu.checkersarchitecture.entity.CheckerData;
import pl.dixu.checkersarchitecture.entity.Color;

public class CheckerView {

    private final CheckerData checker;

    public CheckerView(CheckerData checker) {
        this.checker = checker;
    }

    public boolean hasCords(int row, int col) {
        return checker.getRow() == row && checker.getCol() == col;
    }

    @Override
    public String toString() {
       return FieldView.getViewForChecker(checker.getColor());
    }

    public Color getColor() {
        return checker.getColor();
    }
}
