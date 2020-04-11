package pl.dixu.checkersarchitecture.repository;

import java.util.HashSet;
import java.util.Set;

public class InMemoryCheckerRepository implements CheckerRepository {

    private Set<CheckerData> checkers;

    public InMemoryCheckerRepository() {
        checkers = new HashSet<>();
    }

    @Override
    public void save(Set<CheckerData> newCheckers) {
        checkers.addAll(newCheckers);
    }

    public Set<CheckerData> getCheckers() {
        return new HashSet<>(checkers);
    }
}
