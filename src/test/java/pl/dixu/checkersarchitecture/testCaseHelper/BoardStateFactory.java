package pl.dixu.checkersarchitecture.testCaseHelper;

import pl.dixu.checkersarchitecture.entity.BoardState;
import pl.dixu.checkersarchitecture.entity.CheckerData;
import pl.dixu.checkersarchitecture.entity.Color;

import java.util.HashSet;
import java.util.Set;

public class BoardStateFactory {

    public static BoardState boardWithOneWhiteChecker() {
        Set<CheckerData> checkers = new HashSet<>();
        CheckerData checkerData = new CheckerData(0, 0, Color.WHITE);
        checkers.add(checkerData);
        return new BoardState(checkers, Color.WHITE);
    }

}
