package pl.dixu.checkersarchitecture.entity;

import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Set;

import static pl.dixu.checkersarchitecture.entity.Color.WHITE;

@Component
public class CheckerFactoryWhiteFirst implements CheckerFactory {
    private static final Color INITIAL_COLOR = WHITE;

    private static final int FIRST_PLAYER_ROW_INDEX = 0;
    private static final int SECOND_PLAYER_ROW_INDEX = 5;


    @Override
    public BoardState buildStartingBoardState() {
        Set<CheckerData> checkers = buildStartingCheckers();
        return new BoardState(checkers, WHITE);
    }

    private Set<CheckerData> buildStartingCheckers() {
        Set<CheckerData> checkers = buildPlayerOf(INITIAL_COLOR);
        checkers.addAll(buildPlayerOf(INITIAL_COLOR.nextColor()));
        return checkers;
    }

    private Set<CheckerData> buildPlayerOf(Color color) {
        Set<CheckerData> checkers = new HashSet<>();
        int initialRow = FIRST_PLAYER_ROW_INDEX;
        if (INITIAL_COLOR != color) {
            initialRow = SECOND_PLAYER_ROW_INDEX;
        }
        for (int row = initialRow; row < initialRow+3; row++) {
            checkers.addAll(buildRow(row, color));
        }
        return checkers;
    }

    private Set<CheckerData> buildRow(int rowIndex, Color color) {
        Set<CheckerData> row = new HashSet<>();
        for (int col = 0; col < BoardProperties.COLUMNS_COUNT; col++) {
            if (rowIndex % 2 == 0) {
                if (col % 2 != 0) {
                    row.add(new CheckerData(rowIndex, col, color));
                }
            } else {
                if (col % 2 == 0) {
                    row.add(new CheckerData(rowIndex, col, color));
                }
            }
        }
        return row;
    }

}
