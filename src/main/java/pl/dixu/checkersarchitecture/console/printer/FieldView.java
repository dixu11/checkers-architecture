package pl.dixu.checkersarchitecture.console.printer;

import pl.dixu.checkersarchitecture.entity.Color;

public enum FieldView{
    BLACK_EMPTY("#"), WHITE_EMPTY("O"), BLACK_CHECKER("X"), WHITE_CHECKER("@");
    private String view;

    FieldView(String view) {
        this.view = view;
    }

    public static FieldView getViewForChecker(Color color) {
        if (color == Color.BLACK) {
            return BLACK_CHECKER;
        }
        return WHITE_CHECKER;
    }

    public static FieldView getViewForEmptyField(Color color) {
        if (color == Color.BLACK) {
            return BLACK_EMPTY;
        }
        return WHITE_EMPTY;
    }

    @Override
    public String toString() {
        return view;
    }
}
