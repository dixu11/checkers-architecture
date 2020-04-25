package pl.dixu.checkersarchitecture.entity;

import org.springframework.stereotype.Component;

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
