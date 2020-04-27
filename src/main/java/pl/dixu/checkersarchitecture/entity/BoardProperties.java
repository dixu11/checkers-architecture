package pl.dixu.checkersarchitecture.entity;

class BoardProperties {
    public static final int ROWS_COUNT = 8;
    public static final int COLUMNS_COUNT = 8;

    public static boolean isRowIndexInRange(int row) {
        return row >= 0 && row < ROWS_COUNT;
    }

    public static boolean isColIndexInRange(int col) {
        return col >= 0 && col < COLUMNS_COUNT;
    }
}
