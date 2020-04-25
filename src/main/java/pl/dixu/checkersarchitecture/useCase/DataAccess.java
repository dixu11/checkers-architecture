package pl.dixu.checkersarchitecture.useCase;

import pl.dixu.checkersarchitecture.entity.CheckerData;

import java.util.Set;

public interface DataAccess {
    void save(Set<CheckerData> checkers);
    Set<CheckerData> getCheckers();
}
