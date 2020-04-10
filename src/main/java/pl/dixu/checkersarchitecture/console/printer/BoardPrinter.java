package pl.dixu.checkersarchitecture.console.printer;

import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Set;

@Component
public class BoardPrinter {

    public void printBoard(List<FieldStateConsole> fields){
        if (fields.isEmpty()) {
            throw new PrinterException("No fields received");
        }
        for (FieldStateConsole field : fields) {
            System.out.print(field);
        }
        System.out.println();
    }
}
