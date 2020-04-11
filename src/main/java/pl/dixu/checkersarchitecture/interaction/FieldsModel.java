package pl.dixu.checkersarchitecture.interaction;

import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Set;

@Component
public class FieldsModel {

    private Set<Field> fields;

    public FieldsModel() {
        fields = new HashSet<>();
        FieldFactory factory = new FieldFactory();
        fields = factory.buildFields();
    }


    public Set<Field> getFields() {
        return new HashSet<>(fields);
    }
}
