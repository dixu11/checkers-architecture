package pl.dixu.checkersarchitecture.controller;

import org.springframework.stereotype.Component;
import pl.dixu.checkersarchitecture.interaction.FieldStateData;

import java.util.Set;

public interface Controller {

    Set<FieldStateData> getBoardState();

    void startGame();
}
