package model;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class EpicTest {

    @Test
    void epicsWithSameIdShouldBeEqual() {
        Epic e1 = new Epic(5, "e", "d", Status.NEW);
        Epic e2 = new Epic(5, "other", "other", Status.DONE);

        assertEquals(e1, e2,
                "Наследники Task (Epic) должны сравниваться только по id.");
    }

    @Test
    void epicCannotContainItselfAsSubtask() {
        Epic epic = new Epic(12, "e", "d", Status.NEW);
        epic.addSubtask(99);               // нормальная подзадача
        epic.addSubtask(epic.getId());     // «попытка» добавить себя

        assertFalse(epic.getSubtaskIds().contains(epic.getId()),
                "Epic не должен включать собственный id в список подзадач.");
    }
}