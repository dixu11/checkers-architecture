package pl.dixu.checkersarchitecture.controller;

import org.springframework.stereotype.Component;
import pl.dixu.checkersarchitecture.interaction.FieldStateData;
import pl.dixu.checkersarchitecture.interaction.Interaction;
import pl.dixu.checkersarchitecture.interaction.MoveEvent;

import java.util.Set;

@Component
public class ControllerImpl implements Controller {

    private Interaction interaction;

    public ControllerImpl(Interaction interaction) {
        this.interaction = interaction;
    }

    @Override
    public Set<FieldStateData> getBoardState() {
        return interaction.getBoardState();
    }

    @Override
    public void startGame() {
        interaction.startGame();
    }

    @Override
    public void move(MoveEvent moveEvent) {
        interaction.move(moveEvent);
    }
}
