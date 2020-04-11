package pl.dixu.checkersarchitecture.interaction;

import org.springframework.stereotype.Component;
import pl.dixu.checkersarchitecture.repository.CheckerData;
import pl.dixu.checkersarchitecture.repository.CheckerRepository;

import java.util.Set;

@Component
public class GameInitializerStandard implements GameInitializer {

    private CheckerRepository checkerRepository;
    private CheckerFactory checkerFactory;

    public GameInitializerStandard(CheckerRepository checkerRepository, CheckerFactory checkerFactory) {
        this.checkerRepository = checkerRepository;
        this.checkerFactory = checkerFactory;
    }

    @Override
    public void startGame() {
        Set<CheckerData> checkers = checkerFactory.buildStartingCheckers();
        checkerRepository.save(checkers);
    }
}
