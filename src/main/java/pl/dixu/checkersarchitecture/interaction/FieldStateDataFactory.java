package pl.dixu.checkersarchitecture.interaction;

import org.springframework.stereotype.Component;
import pl.dixu.checkersarchitecture.repository.CheckerData;
import pl.dixu.checkersarchitecture.repository.CheckerRepository;

import java.util.Set;
import java.util.stream.Collectors;

@Component
public class FieldStateDataFactory {

    private FieldsModel fieldsModel;
    private CheckerRepository repository;

    public FieldStateDataFactory(FieldsModel fieldsModel, CheckerRepository repository) {
        this.fieldsModel = fieldsModel;
        this.repository = repository;
    }

    public Set<FieldStateData> buildBoardStateData() {
        Set<FieldStateData> fieldStateData = buildFields();
        putCheckers(fieldStateData);
        return fieldStateData;
    }

    private Set<FieldStateData> buildFields() {
        return fieldsModel.getFields()
                .stream()
                .map(FieldStateData::new)
                .collect(Collectors.toSet());
    }

    public void putCheckers(Set<FieldStateData> fields) {
        Set<CheckerData> checkers = repository.getCheckers();
        checkers.forEach(checker ->
                fields.forEach(field -> field.addCheckerIfPositionsMatchField(checker)));
    }





}
