package pl.dixu.checkersarchitecture.entity;

import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Component
public class ActualBoardStateFactory {

    private FieldsModel fieldsModel;
    private Set<FieldStateData> boardState; //immutable

    public ActualBoardStateFactory(FieldsModel fieldsModel) {
        this.fieldsModel = fieldsModel;
        boardState = new HashSet<>();
    }

    public Set<FieldStateData> buildActualBoardState(Set<CheckerData> checkers) {
        boardState = buildEmptyFields();
        boardState = putCheckers(checkers);
        return boardState;
    }

    private Set<FieldStateData> buildEmptyFields() {
        return convertFieldsToFieldStates();
    }

    private Set<FieldStateData> convertFieldsToFieldStates() {
        return fieldsModel.getFields()
                .stream()
                .map(FieldStateData::new)
                .collect(Collectors.toSet());
    }

    private Set<FieldStateData> putCheckers(Set<CheckerData> checkers) {
        return boardState.stream()
                .map(emptyField -> putCheckerOnField(checkers, emptyField))
                .collect(Collectors.toSet());
    }

    private FieldStateData putCheckerOnField(Set<CheckerData> checkers, FieldStateData emptyField) {
        FieldStateData updatedField = emptyField;
        Optional<CheckerData> checkerOnField = checkers.stream()
                .filter(emptyField::cordsMatches)
                .findFirst();

        if (checkerOnField.isPresent()) {
            updatedField = updatedField.putChecker(checkerOnField.get());
        }
        return updatedField;
    }

}
