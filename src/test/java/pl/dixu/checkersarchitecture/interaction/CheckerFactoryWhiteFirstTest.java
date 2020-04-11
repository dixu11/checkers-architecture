package pl.dixu.checkersarchitecture.interaction;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.util.Assert;
import pl.dixu.checkersarchitecture.repository.CheckerData;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;

class CheckerFactoryWhiteFirstTest {

    private CheckerFactoryWhiteFirst checkerFactory;

    @BeforeEach
    void setUp() {
        checkerFactory = new CheckerFactoryWhiteFirst();
    }

    @Test
    void buildStartingCheckers_should_build_accurate_amount_of_checkers() {
        Set<CheckerData> checkers = checkerFactory.buildStartingCheckers();

        assertEquals(24, checkers.size());
    }

    @Test
    void buildStartingCheckers_should_put_correct_checkers_on_white_player_first_row() {
        int rowNr = 0;
        Set<CheckerData> firstRow = Set.of(new CheckerData(rowNr, 1, Color.WHITE),
                new CheckerData(rowNr, 3, Color.WHITE),
                new CheckerData(rowNr, 5, Color.WHITE),
                new CheckerData(rowNr, 7, Color.WHITE));

        Set<CheckerData> actual = checkerFactory.buildStartingCheckers();

        actual = actual.stream()
                .filter(checker -> checker.getRow() == rowNr)
                .collect(Collectors.toSet());
        assertEquals(firstRow, actual);
    }

    @Test
    void buildStartingCheckers_should_put_correct_checkers_on_black_player_first_row() {
        int rowNr = 5;
        Set<CheckerData> firstRow = Set.of(new CheckerData(rowNr, 0, Color.BLACK),
                new CheckerData(rowNr, 2, Color.BLACK),
                new CheckerData(rowNr, 4, Color.BLACK),
                new CheckerData(rowNr, 6, Color.BLACK));

        Set<CheckerData> actual = checkerFactory.buildStartingCheckers();

        actual = actual.stream()
                .filter(checker -> checker.getRow() == rowNr)
                .collect(Collectors.toSet());
        assertEquals(firstRow, actual);
    }
}