package pl.dixu.checkersarchitecture.entity;

import org.springframework.stereotype.Component;

import java.util.Set;

//fasada warsty entity
@Component
public class CheckerGame {

    private ActualBoardStateFactory factory;

    public CheckerGame(ActualBoardStateFactory factory) {
        this.factory = factory;
    }

    public Set<FieldStateData> getBoardState(Set<CheckerData> checkers) {
       return factory.buildActualBoardState(checkers);
    }


}
