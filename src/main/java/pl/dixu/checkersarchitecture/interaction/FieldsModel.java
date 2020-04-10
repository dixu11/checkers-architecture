package pl.dixu.checkersarchitecture.interaction;

import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static pl.dixu.checkersarchitecture.interaction.Color.*;
@Component
public class FieldsModel {

    private Set<Field> fields;
    private static final Color INITIAL_COLOR = WHITE;


    public FieldsModel() {
        fields = new HashSet<>();
        fields = buildFields();
    }

    private Set<Field> buildFields() {
        return IntStream.range(0, BoardProperties.ROWS_COUNT)
                .mapToObj(this::buildRow)
                .flatMap(Collection::stream)
                .collect(Collectors.toSet());
    }

    private Set<Field> buildRow(int rowIndex) {
        Color rowColor = determineFirstColor(rowIndex);
        return buildRowFields(rowIndex, rowColor);
    }

    private Color determineFirstColor(int rowIndex) {
        Color rowColor = INITIAL_COLOR;
        if (rowIndex % 2 != 0) {
            rowColor = rowColor.nextColor();
        }
        return rowColor;
    }

    private Set<Field> buildRowFields(int rowIndex, Color rowColor) {
        Set<Field> row = new HashSet<>();
        for (int columnIndex = 0; columnIndex < BoardProperties.COLUMNS_COUNT; columnIndex++) {
            Color actualColor = determineFieldColor(rowColor, columnIndex);
            row.add(new Field(rowIndex, columnIndex, actualColor));
        }
        return row;
    }

    //todo refactor?
    private Color determineFieldColor(Color rowColor, int columnIndex) {
        Color actualColor = rowColor;
        if (columnIndex % 2 != 0) {
            actualColor = actualColor.nextColor();
        }
        return actualColor;
    }

    public Set<Field> getFields() {
        return new HashSet<>(fields);
    }
}
