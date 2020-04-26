package pl.dixu.checkersarchitecture.repository;

import org.springframework.stereotype.Component;
import pl.dixu.checkersarchitecture.entity.BoardState;
import pl.dixu.checkersarchitecture.useCase.DataAccess;

import java.util.Set;
@Component
public class InMemoryCheckerRepository implements DataAccess {

    private BoardState boardState;

    public InMemoryCheckerRepository() {

    }

    public void save(BoardState boardState) {
        this.boardState = boardState;
    }

    public BoardState getBoardState() {
        return boardState;
    }

    public void setBoardState(BoardState boardState) {
        this.boardState = boardState;
    }
}
