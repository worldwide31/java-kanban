package model;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class SubtaskTest {

    @Test
    void subtasksWithSameIdShouldBeEqual() {
        Subtask s1 = new Subtask(7, "s", "desc", Status.NEW, 42);
        Subtask s2 = new Subtask(7, "other", "other", Status.DONE, 99);

        assertEquals(s1, s2,
                "Наследники Task (Subtask) должны сравниваться только по id.");
    }

    @Test
    void subtaskCannotBeItsOwnEpic() {
        Subtask subtask = new Subtask(10, "Subtask", "Описание", Status.NEW, 99);
        assertNotEquals(subtask.getId(), subtask.getEpicId(), "Subtask не может ссылаться на себя в качестве эпика.");
    }

}