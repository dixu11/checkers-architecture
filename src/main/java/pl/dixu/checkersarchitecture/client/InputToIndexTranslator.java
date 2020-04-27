package pl.dixu.checkersarchitecture.client;

import static java.lang.Math.abs;

public class InputToIndexTranslator {

    int translateInputRowToIndex(int row) {
        return 8 - row;
    }

    int translateInputColToIndex(int col) {
        return col - 1;
    }

    int translateIndexRowToInput(int row) {
        return abs(row - 8);
    }

    int translateIndexColToInput(int col) {
        return col + 1;
    }
}
