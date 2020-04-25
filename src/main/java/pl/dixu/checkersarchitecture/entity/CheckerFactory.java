package pl.dixu.checkersarchitecture.entity;

import java.util.Set;

public interface CheckerFactory {
    Set<CheckerData> buildStartingCheckers();
}
