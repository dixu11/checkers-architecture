package pl.dixu.checkersarchitecture.console.printer;

import pl.dixu.checkersarchitecture.interaction.FieldStateData;

import java.util.List;
import java.util.Set;

public interface FieldStateDataTranslator {

    List<FieldStateConsole> convertToConsoleFieldState(Set<FieldStateData> fields);

}
