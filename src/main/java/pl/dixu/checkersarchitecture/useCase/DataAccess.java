package pl.dixu.checkersarchitecture.useCase;

import pl.dixu.checkersarchitecture.entity.BoardState;

public interface DataAccess {
    void save(BoardState boardState);
    BoardState getBoardState();
}
