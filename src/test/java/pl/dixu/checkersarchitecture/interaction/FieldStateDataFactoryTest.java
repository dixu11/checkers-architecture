package pl.dixu.checkersarchitecture.interaction;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.stereotype.Repository;
import pl.dixu.checkersarchitecture.repository.CheckerData;
import pl.dixu.checkersarchitecture.repository.CheckerRepository;
import pl.dixu.checkersarchitecture.repository.InMemoryCheckerRepository;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class FieldStateDataFactoryTest {
    private FieldStateDataFactory factory;
    private CheckerRepository repositoryMock;
    private FieldsModel modelMock;

    @BeforeEach
    void setUp() {
        modelMock = Mockito.mock(FieldsModel.class);
        repositoryMock = Mockito.mock(CheckerRepository.class);
        factory = new FieldStateDataFactory(modelMock,repositoryMock);
    }

    @Test
    void buildBoardStateData_adds_checkers_to_correct_fields() {
        int rowNr = 0;
        CheckerData checkerData = new CheckerData(rowNr, 1, Color.WHITE);
        Set<CheckerData> expectedCheckers = Set.of(checkerData);
        Mockito.when(repositoryMock.getCheckers()).thenReturn(expectedCheckers);
        Field field0 = new Field(rowNr,0,Color.WHITE);
        Field field1 = new Field(rowNr,1,Color.BLACK);
        Field field2 = new Field(rowNr,2,Color.WHITE);
        Field field3 = new Field(rowNr,3,Color.BLACK);
        Set<Field> expectedFields = Set.of(field0,field1, field2, field3);
        Mockito.when(modelMock.getFields()).thenReturn(expectedFields);


        FieldStateData expectedCheckerField = new FieldStateData(field1);
        FieldStateData expectedNoCheckerField = new FieldStateData(field2);
        FieldStateData notExpectedEmptyField = new FieldStateData(field3);
        expectedCheckerField.setCheckerData(checkerData);

        Set<FieldStateData> actualFieldStateData = factory.buildBoardStateData();
        FieldStateData fieldStateData = actualFieldStateData.stream()
                .filter(data -> data.getRow() == 0 && data.getColumn() == 1)
                .findFirst()
                .orElse(null);
       /* System.out.println(fieldStateData.equals(expectedCheckerField));

        System.out.println("Concrete:");
        System.out.println(field1.equals(fieldStateData.getField()));
        System.out.println(checkerData.equals(fieldStateData.getCheckerData()));
        System.out.println(fieldStateData.equals(expectedCheckerField));*/

        System.out.println("Final:");
        System.out.println(actualFieldStateData.contains(fieldStateData));
        System.out.println(actualFieldStateData.contains(expectedCheckerField));
        assertTrue(actualFieldStateData.contains(expectedCheckerField));
        assertTrue(actualFieldStateData.contains(expectedNoCheckerField));
        assertFalse(actualFieldStateData.contains(notExpectedEmptyField));
    }
}