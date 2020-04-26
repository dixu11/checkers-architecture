package pl.dixu.checkersarchitecture.adapters;

import org.springframework.stereotype.Controller;
import pl.dixu.checkersarchitecture.entity.BoardState;
import pl.dixu.checkersarchitecture.entity.MoveResult;

@Controller
public interface Presenter {
     void showBoard(BoardState boardState);

     void showMove(MoveResult moveResult);
}
