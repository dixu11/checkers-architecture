package pl.dixu.checkersarchitecture.client;

import pl.dixu.checkersarchitecture.entity.Color;

public enum FieldView{
    BLACK_EMPTY("#"), WHITE_EMPTY(" "), BLACK_CHECKER("X"), WHITE_CHECKER("O");
    private String view;

    FieldView(String view) {
        this.view = view;
    }

    public static String getViewForChecker(Color color) {
        if (color == Color.BLACK) {
            return BLACK_CHECKER.view;
        }
        return WHITE_CHECKER.view;
    }

    public static String getViewForEmptyField(Color color) {
        if (color == Color.BLACK) {
            return BLACK_EMPTY.view;
        }
        return WHITE_EMPTY.view;
    }

    @Override
    public String toString() {
        return view;
    }
}
