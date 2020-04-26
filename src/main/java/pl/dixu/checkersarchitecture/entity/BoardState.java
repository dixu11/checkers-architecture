package pl.dixu.checkersarchitecture.entity;

import java.util.Objects;
import java.util.Set;

public class BoardState {
    private final Set<CheckerData> fieldStates;
    private final Color actualPlayer;

    public BoardState(Set<CheckerData> fieldStates, Color actualPlayer) {
        this.fieldStates = fieldStates;
        this.actualPlayer = actualPlayer;
    }

    public Set<CheckerData> getCheckers() {
        return fieldStates;
    }

    public Color getActualPlayer() {
        return actualPlayer;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BoardState that = (BoardState) o;
        return Objects.equals(fieldStates, that.fieldStates) &&
                actualPlayer == that.actualPlayer;
    }

    @Override
    public int hashCode() {
        return Objects.hash(fieldStates, actualPlayer);
    }
}
