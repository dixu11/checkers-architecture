package pl.dixu.checkersarchitecture.repository;

import org.springframework.stereotype.Component;

import java.util.Set;


public interface CheckerRepository {
    void save(Set<CheckerData> checkers);
    Set<CheckerData> getCheckers();
}
