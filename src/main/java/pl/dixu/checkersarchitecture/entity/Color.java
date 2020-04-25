package pl.dixu.checkersarchitecture.entity;

public enum Color {
    BLACK, WHITE;

    public Color nextColor() {
        if (this == WHITE) {
            return BLACK;
        } else {
            return WHITE;
        }
    }
}
