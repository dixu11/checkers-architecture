package pl.dixu.checkersarchitecture.interaction;

import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

@Component
public class FieldStateDataFactory {

    private FieldsModel fieldsModel;

    public FieldStateDataFactory(FieldsModel fieldsModel) {
        this.fieldsModel = fieldsModel;
    }


    public Set<FieldStateData> buildBoardStateData() {
        return fieldsModel.getFields()
                .stream()
                .map(FieldStateData::new)   //todo also checkers
                .collect(Collectors.toSet());

    }



}
