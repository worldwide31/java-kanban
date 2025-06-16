package task;

import model.Status;
import model.Subtask;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SubtaskTest {
    @Test
    void selfEpicNotAllowed() {
        assertThrows(IllegalArgumentException.class, () -> new Subtask(1, "Subtask1", "Desc1", Status.NEW, 1),
                "Подзадача не должна быть своим же эпиком.");
    }
}