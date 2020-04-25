package pl.dixu.checkersarchitecture.console.printer;

import pl.dixu.checkersarchitecture.entity.FieldStateData;

public class FieldStateConsole implements Comparable<FieldStateConsole> {

    private FieldStateData data;
    private static final  String NEW_LINE = "\n";
    private static final int COLUMNS_COUNT = 8;


    public FieldStateConsole(FieldStateData data) {
        this.data = data;
    }

    private String getFieldView() {
        String view = computeFieldSymbol();
        view += " ";
        view = addSpaceIfLastColumn(view);
        return view;
    }

    private String computeFieldSymbol() {
        String symbol = "";
        if (data.hasChecker()) {
            symbol += FieldView.getViewForChecker(data.getCheckerColor());
        } else {
            symbol += FieldView.getViewForEmptyField(data.getFieldColor());
        }
        return symbol;
    }

    private String addSpaceIfLastColumn(String view) {
        if (getColumn() == getLastColumnIndex()) {
            view += NEW_LINE;
        }
        return view;
    }

    private int getLastColumnIndex() {
        return COLUMNS_COUNT -1;
    }

    @Override
    public int compareTo(FieldStateConsole o) {
        int compareResult = Integer.compare(getRow(), o.getRow());
        if (compareResult == 0) {
            compareResult = Integer.compare(getColumn(), o.getColumn());
        }
        return compareResult;
    }

    public int getRow() {
        return data.getRow();
    }

    public int getColumn() {
        return data.getColumn();
    }

    @Override
    public String toString() {
        return getFieldView();
    }


}


