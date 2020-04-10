package pl.dixu.checkersarchitecture.console.printer;

import org.springframework.stereotype.Component;
import pl.dixu.checkersarchitecture.interaction.FieldStateData;

import java.util.Set;

@Component
public class BoardPrintingHandler {

    private FieldStateDataTranslator translator;
    private BoardPrinter printer;

    public BoardPrintingHandler(FieldStateDataTranslator translator, BoardPrinter printer) {
        this.translator = translator;
        this.printer = printer;
    }

    public void printBoard(Set<FieldStateData> fields){
        Set<FieldStateConsole> consoleFields = translator.convertToConsoleFieldState(fields);
        printer.printBoard(consoleFields);
    }




}
