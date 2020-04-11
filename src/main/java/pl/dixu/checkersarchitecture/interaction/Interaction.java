package pl.dixu.checkersarchitecture.interaction;

import org.springframework.stereotype.Component;

import java.util.Set;
@Component
public  class Interaction {

    private GameInitializer initializer;
    private InformerFacade informer;
    private Executor executor;

    public Interaction(GameInitializer initializer, InformerFacade informer, Executor executor) {
        this.initializer = initializer;
        this.informer = informer;
        this.executor = executor;
    }

    public Set<FieldStateData> getBoardState() {
        return informer.getBoardState();
    }

    public void startGame() {
        initializer.startGame();
    }

    public void move(MoveEvent moveEvent) {
        executor.move(moveEvent);
    }
}
