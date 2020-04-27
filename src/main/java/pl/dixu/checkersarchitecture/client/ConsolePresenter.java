package pl.dixu.checkersarchitecture.client;

import org.springframework.stereotype.Component;
import pl.dixu.checkersarchitecture.adapters.Presenter;
import pl.dixu.checkersarchitecture.entity.BoardState;
import pl.dixu.checkersarchitecture.entity.MoveResult;

@Component
class ConsolePresenter implements Presenter {

    private CheckerDataTranslator translator;

    public ConsolePresenter(CheckerDataTranslator translator) {
        this.translator = translator;
    }

    public void showBoard(BoardState boardState){
        BoardStateView boardStateView = translator.convertToBoardStateView(boardState);
        clearScreen();
        boardStateView.printBoard();
    }

    @Override
    public void executeMove(MoveResult moveResult) {
        showBoard(moveResult.getBoardState());
    }

    private void clearScreen() {
        for (int i = 0; i < 25; i++) {
            System.out.println();
        }
    }





}
