package pl.dixu.checkersarchitecture.interaction;

import java.util.Objects;

public class FieldStateData {

    private Field field;

    public FieldStateData(Field field) {
        this.field = field;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FieldStateData that = (FieldStateData) o;
        return Objects.equals(field, that.field);
    }

    @Override
    public int hashCode() {
        return Objects.hash(field);
    }


    public int getRow() {
        return field.getRow();
    }
    public int getColumn() {
        return field.getColumn();
    }

    public Color getFieldColor() {
        return field.getColor();
    }

    public Color getCheckerColor() {
        return null; //todo
    }

    public boolean hasChecker() {
        return false; // todo
    }
}
