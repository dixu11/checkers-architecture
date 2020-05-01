package pl.dixu.checkersarchitecture.client;

import org.springframework.stereotype.Component;
import pl.dixu.checkersarchitecture.adapters.Presenter;
import pl.dixu.checkersarchitecture.entity.BoardState;
import pl.dixu.checkersarchitecture.entity.MoveResult;
import pl.dixu.checkersarchitecture.entity.MoveValidationStatus;

import static pl.dixu.checkersarchitecture.entity.MoveValidationStatus.*;

@Component
class ConsolePresenter implements Presenter {

    private CheckerDataTranslator translator;
    private DialogPrinter printer;

    public ConsolePresenter(CheckerDataTranslator translator, DialogPrinter printer) {
        this.translator = translator;
        this.printer = printer;
    }

    public void showBoard(BoardState boardState) {
        BoardStateView boardStateView = translator.convertToBoardStateView(boardState);
        boardStateView.printBoard();
    }

    @Override
    public void executeMove(MoveResult moveResult) {
        clearScreen();
        printCorrectNotification(moveResult);
        showBoard(moveResult.getBoardState());
    }

    private void printCorrectNotification(MoveResult moveResult) {
        if (moveResult.wasExecuted()) {
            printer.notifyCorrectMove();
            return;
        }
        MoveValidationStatus validation = moveResult.getValidation();
        if (validation == OUTSIDE_BOARD) {
            printer.outOfBoardError();
        }
        if (validation == NO_CHECKER) {
            printer.noCheckerSelectedError();
        }
        if (validation == NOT_YOUR_CHECKER) {
            printer.notYourCheckerSelectedError();
        }
        if (validation == NOT_VALID_MOVE) {
            printer.notValidMoveError();
        }
        if (validation == FIELD_BLOCKED) {
            printer.fieldBlockedError();
        }
        if (validation == NO_STATUS) {
            printer.noStatusError();
        }
    }

    private void clearScreen() {
        for (int i = 0; i < 25; i++) {
            System.out.println();
        }
    }

}
