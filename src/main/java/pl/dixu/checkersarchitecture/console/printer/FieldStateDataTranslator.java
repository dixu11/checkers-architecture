package pl.dixu.checkersarchitecture.console.printer;

import pl.dixu.checkersarchitecture.interaction.FieldStateData;

import java.util.Set;

public interface FieldStateDataTranslator {

    Set<FieldStateConsole> convertToConsoleFieldState(Set<FieldStateData> fields);

}
