package pl.dixu.checkersarchitecture.client;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pl.dixu.checkersarchitecture.entity.MoveResult;
import pl.dixu.checkersarchitecture.testCaseHelper.MoveResultFactory;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static pl.dixu.checkersarchitecture.testCaseHelper.MoveResultFactory.*;

class ConsolePresenterTest {

    private ConsolePresenter presenter;
    private DialogPrinter printerMock;

    @BeforeEach
    void before() {
        printerMock = mock(DialogPrinter.class);
        presenter = new ConsolePresenter(new CheckerDataTranslator(), printerMock);
    }

    @Test
    void outside_board_validation_should_result_in_proper_error_invocation() {
        MoveResult move = moveOutsideBoard();
        presenter.executeMove(move);
        verify(printerMock).outOfBoardError();
    }

    @Test
    void no_checker_validation_should_result_in_proper_error_invocation() {
        MoveResult move = moveWithNoCheckerSelected();
        presenter.executeMove(move);
        verify(printerMock).noCheckerSelectedError();
    }

    @Test
    void not_valid_move_should_result_in_proper_error_invocation() {
        MoveResult move = MoveResultFactory.notValidMove();
        presenter.executeMove(move);
        verify(printerMock).notValidMoveError();
    }

    @Test
    void field_blocked_validation_should_result_in_proper_error_invocation() {
        MoveResult move = MoveResultFactory.moveOnBlockedField();
        presenter.executeMove(move);
        verify(printerMock).fieldBlockedError();
    }

    @Test
    void no_status_validation_should_result_in_proper_error_invocation() {
        MoveResult move = MoveResultFactory.moveWithNoStatus();
        presenter.executeMove(move);
        verify(printerMock).noStatusError();
    }

    @Test
    void correct_validation_should_result_in_proper_notification_invocation() {
        MoveResult move = MoveResultFactory.correctMove();
        presenter.executeMove(move);
        verify(printerMock).notifyCorrectMove();
    }

    @Test
    void not_your_checker_validation_should_result_in_proper_error_invocation() {
        MoveResult move = moveWithNotYourCheckerSelected();
        presenter.executeMove(move);
        verify(printerMock).notYourCheckerSelectedError();
    }

    /*TestFactory
    Collection<DynamicTest> validation_should_result_in_proper_print_invocation() {
        return List.of(
                dynamicTest("outside board",
                        () -> verify(printerMock).outOfBoardError()),
                dynamicTest("no checker",
                        () -> verify(printerMock).noCheckerSelectedError()),
                dynamicTest("not your checker",
                        () -> verify(printerMock).notYourCheckerSelectedError())
                );
    }*/
}