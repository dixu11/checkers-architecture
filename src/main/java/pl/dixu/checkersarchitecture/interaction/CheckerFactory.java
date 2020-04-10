package pl.dixu.checkersarchitecture.interaction;

import org.springframework.stereotype.Component;
import pl.dixu.checkersarchitecture.repository.CheckerData;

import java.util.HashSet;
import java.util.Set;

@Component
public class CheckerFactory {

    Set<CheckerData> buildStartingCheckers() {
        return new HashSet<>();
    }

}
