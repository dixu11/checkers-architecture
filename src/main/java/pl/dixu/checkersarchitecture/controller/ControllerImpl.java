package pl.dixu.checkersarchitecture.controller;

import org.springframework.stereotype.Component;
import pl.dixu.checkersarchitecture.interaction.FieldStateData;
import pl.dixu.checkersarchitecture.interaction.GameInitializer;
import pl.dixu.checkersarchitecture.interaction.InformerFacade;

import java.util.Set;

@Component
public class ControllerImpl implements Controller {

    private InformerFacade informer;
    private GameInitializer initializer;

    public ControllerImpl(InformerFacade informer, GameInitializer initializer) {
        this.informer = informer;
        this.initializer = initializer;
    }

    @Override
    public Set<FieldStateData> getBoardState() {
        return informer.getBoardState();
    }

    @Override
    public void startGame() {
        initializer.startGame();
    }
}
