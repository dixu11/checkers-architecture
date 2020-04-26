package pl.dixu.checkersarchitecture.client;

import org.springframework.stereotype.Component;
import pl.dixu.checkersarchitecture.entity.BoardState;
import pl.dixu.checkersarchitecture.entity.CheckerData;
import java.util.Set;
import java.util.stream.Collectors;

@Component
public class CheckerDataTranslator {

    public BoardStateView convertToBoardStateView(BoardState boardState) {
        Set<CheckerView> checkerViews = convertToConsoleCheckerView(boardState.getCheckers());
        return new BoardStateView(checkerViews,boardState.getActualPlayer());
    }

    private Set<CheckerView> convertToConsoleCheckerView(Set<CheckerData> checkerData) {
        return checkerData.stream()
                .map(CheckerView::new)
                .collect(Collectors.toSet());
    }
}
