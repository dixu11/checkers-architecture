package pl.dixu.checkersarchitecture.interaction;

import org.springframework.stereotype.Component;
import pl.dixu.checkersarchitecture.repository.Repository;

@Component
public class GameInitializerStandard implements GameInitializer {

    private Repository repository;
    private CheckerFactory checkerFactory;

    public GameInitializerStandard(Repository repository, CheckerFactory checkerFactory) {
        this.repository = repository;
        this.checkerFactory = checkerFactory;
    }

    @Override
    public void startGame() {
        //todo - > build checkers
    }
}
