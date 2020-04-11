package pl.dixu.checkersarchitecture.controller;

import pl.dixu.checkersarchitecture.interaction.FieldStateData;
import pl.dixu.checkersarchitecture.interaction.MoveEvent;

import java.util.Set;

public interface Controller {

    Set<FieldStateData> getBoardState();

    void startGame();

    void move(MoveEvent moveEvent);

}
