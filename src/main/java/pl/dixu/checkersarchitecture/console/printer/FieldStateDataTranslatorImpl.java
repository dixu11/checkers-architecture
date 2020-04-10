package pl.dixu.checkersarchitecture.console.printer;

import org.springframework.stereotype.Component;
import pl.dixu.checkersarchitecture.interaction.FieldStateData;

import java.util.Set;
import java.util.stream.Collectors;

@Component
public class FieldStateDataTranslatorImpl implements FieldStateDataTranslator {
    @Override
    public Set<FieldStateConsole> convertToConsoleFieldState(Set<FieldStateData> fields) {
        return fields.stream()
                .map(FieldStateConsole::new)
                .collect(Collectors.toSet());
    }
}
