package pl.dixu.checkersarchitecture.entity;

import org.springframework.stereotype.Component;

import java.util.Set;

@Component
public class InformerFacade {

    private ActualBoardStateFactory factory;

    public InformerFacade(ActualBoardStateFactory factory) {
        this.factory = factory;
    }

    public Set<FieldStateData> getBoardState() {
        return factory.buildBoardStateData();
    }

}
