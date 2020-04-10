package pl.dixu.checkersarchitecture.interaction;

import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Set;

@Component
public class InformerFacade {

    private FieldStateDataFactory factory;

    public InformerFacade(FieldStateDataFactory factory) {
        this.factory = factory;
    }

    public Set<FieldStateData> getBoardState() {
        return factory.buildBoardStateData();
    }

}
