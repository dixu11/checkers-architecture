package pl.dixu.checkersarchitecture.entity;

import java.util.Objects;
//immutable
public class FieldStateData {

    private final Field field;
    private final CheckerData checkerData;

    public FieldStateData(Field field) {
        this.field = field;
        checkerData = null;
    }

    public FieldStateData(Field field, CheckerData checkerData) {
        this.field = field;
        this.checkerData = checkerData;
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
        return checkerData.getColor();
    }

    public boolean hasChecker() {
        return !Objects.isNull(checkerData);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FieldStateData that = (FieldStateData) o;
        return field.equals(that.field) &&
                Objects.equals(checkerData, that.checkerData);
    }

    @Override
    public int hashCode() {
        return Objects.hash(field, checkerData);
    }

    public Field getField() {
        return field;
    }

    public FieldStateData putChecker(CheckerData checkerData) {
        return new FieldStateData(field,checkerData);
    }

    public boolean cordsMatches(CheckerData checker) {
        return field.getRow() == checker.getRow() && field.getColumn() == checker.getCol();
    }
}
