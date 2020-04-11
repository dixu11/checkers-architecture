package pl.dixu.checkersarchitecture.interaction;

import pl.dixu.checkersarchitecture.repository.CheckerData;

import java.util.Objects;

public class FieldStateData {

    private Field field;
    private CheckerData checkerData = null;

    public FieldStateData(Field field) {
        this.field = field;
    }

    public CheckerData getCheckerData() {
        return checkerData;
    }

    public void setCheckerData(CheckerData checkerData) {
        this.checkerData = checkerData;
    }

    public void addCheckerIfPositionsMatchField(CheckerData newChecker) {
        if (field.getRow() == newChecker.getRow() && field.getColumn() == newChecker.getCol()) {
            checkerData = newChecker;
        }
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
}
