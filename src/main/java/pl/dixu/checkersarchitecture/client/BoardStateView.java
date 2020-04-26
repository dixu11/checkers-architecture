package pl.dixu.checkersarchitecture.client;

import pl.dixu.checkersarchitecture.entity.Color;
import java.util.Optional;
import java.util.Set;
import static pl.dixu.checkersarchitecture.entity.Color.WHITE;

public class BoardStateView {
    private static final int ROW_COUNT = 8;
    private static final int COLUMN_COUNT = 8;
    private static final Color INITIAL_COLOR = WHITE;

    private Set<CheckerView> checkers;
    private Color actualPlayer;

    public BoardStateView(Set<CheckerView> checkers, Color actualPlayer) {
        this.checkers = checkers;
        this.actualPlayer = actualPlayer;
    }

    public void printBoard() {
        printOnlyBoard();
        printWhoPlays();
    }

    private void printWhoPlays() {
        System.out.println("It is turn of player: " + FieldView.getViewForChecker(actualPlayer));
    }

    private void printOnlyBoard() {
        for (int row = 0; row < ROW_COUNT; row++) {
            for (int col = 0; col < COLUMN_COUNT; col++) {
                printField(row, col);
            }
            System.out.println();
        }
    }

    private void printField(int row, int col) {
        Optional<CheckerView> checkerViewOptional = findChecker(row, col);
        String view;
        if (checkerViewOptional.isPresent()) {
            view = checkerViewOptional.get().toString();
        } else  {
            view = getEmptyFieldView(row, col);
        }
        System.out.print(view + " ");
    }


    private String getEmptyFieldView(int row, int col) {
        String view;
        Color color = determineFirstColor(row);
        if (col % 2 == 0) {
            view = FieldView.getViewForEmptyField(color);
        } else {
           view = FieldView.getViewForEmptyField(color.nextColor());
        }
        return view;
    }

    private Color determineFirstColor(int rowIndex) {
        Color rowColor = INITIAL_COLOR;
        if (rowIndex % 2 != 0) {
            rowColor = rowColor.nextColor();
        }
        return rowColor;
    }

    private Optional<CheckerView> findChecker(int row, int col) {
       return checkers.stream()
                .filter(checker -> checker.hasCords(row, col))
                .findAny();
    }


}
