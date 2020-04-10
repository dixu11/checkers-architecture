package pl.dixu.checkersarchitecture.console.printer;

import pl.dixu.checkersarchitecture.interaction.FieldStateData;

import static java.lang.String.format;

public class FieldStateConsole {

    private FieldStateData data;
    private static final  String NEW_LINE = "\n";
    private static final int ROWS_COUNT = 8;


    public FieldStateConsole(FieldStateData data) {
        this.data = data;
    }

    private String getFieldView() {
        String view = "";

        if (data.hasChecker()) {
            view += FieldView.getViewForChecker(data.getCheckerColor());
        } else {
            view += FieldView.getViewForEmptyField(data.getFieldColor());
        }
        if (data.getRow() == getLastIndex()) {
            view += NEW_LINE;
        }
        return view;
    }

    private int getLastIndex() {
        return ROWS_COUNT -1;
    }

    @Override
    public String toString() {
        return getFieldView();
    }




}


