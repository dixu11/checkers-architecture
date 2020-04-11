package pl.dixu.checkersarchitecture.repository;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pl.dixu.checkersarchitecture.interaction.Color;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class InMemoryCheckerRepositoryTest {

    private CheckerRepository checkerRepository;

    @BeforeEach
    void setUp() {
        checkerRepository = new InMemoryCheckerRepository();
    }

    @Test
    void save() {
        int rowNr = 0;
        Set<CheckerData> expectedCheckers = Set.of(new CheckerData(rowNr, 1, Color.WHITE),
                new CheckerData(rowNr, 3, Color.WHITE),
                new CheckerData(rowNr, 5, Color.WHITE),
                new CheckerData(rowNr, 7, Color.WHITE));

        checkerRepository.save(expectedCheckers);

        assertEquals(expectedCheckers, checkerRepository.getCheckers());
    }
}