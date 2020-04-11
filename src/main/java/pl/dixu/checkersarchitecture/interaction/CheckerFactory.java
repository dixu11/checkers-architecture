package pl.dixu.checkersarchitecture.interaction;

import pl.dixu.checkersarchitecture.repository.CheckerData;

import java.util.Set;

public interface CheckerFactory {
    Set<CheckerData> buildStartingCheckers();
}
