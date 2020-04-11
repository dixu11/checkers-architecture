package pl.dixu.checkersarchitecture.interaction;

import org.springframework.stereotype.Component;

import java.util.Set;
@Component
public  class Interaction {

    private GameInitializer initializer;
    private InformerFacade informer;

    public Interaction(GameInitializer initializer, InformerFacade informer) {
        this.initializer = initializer;
        this.informer = informer;
    }

    public Set<FieldStateData> getBoardState() {
        return informer.getBoardState();
    }

    public void startGame() {
        initializer.startGame();
    }
}
