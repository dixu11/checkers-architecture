package pl.dixu.checkersarchitecture.entity;

import java.util.Objects;
import java.util.Optional;
import java.util.Set;

public class BoardState {
    private final Set<CheckerData> checkers;
    private final Color actualPlayer;

    public BoardState(Set<CheckerData> checkers, Color actualPlayer) {
        this.checkers = checkers;
        this.actualPlayer = actualPlayer;
    }

    public Set<CheckerData> getCheckers() {
        return checkers;
    }

    public Color getActualPlayer() {
        return actualPlayer;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BoardState that = (BoardState) o;
        return Objects.equals(checkers, that.checkers) &&
                actualPlayer == that.actualPlayer;
    }

    public Optional<CheckerData> findChecker(int row, int col) {
        return checkers.stream()
                .filter(checker -> checker.isOnCords(row, col))
                .findAny();
    }

    public CheckerData findCheckerOrThrow(int row, int col){
        return findChecker(row, col).orElseThrow();
    }

    public boolean hasChecker(int row, int col) {
        return findChecker(row, col).isPresent();
    }

    @Override
    public int hashCode() {
        return Objects.hash(checkers, actualPlayer);
    }
}
