package task;

import model.Epic;
import model.Status;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EpicTest {
    @Test
    void selfReferenceNotAllowed() {
        Epic epic = new Epic(1, "Epic1", "Desc1", Status.NEW);
        assertThrows(IllegalArgumentException.class, () -> epic.addSubtask(epic.getId()), "Эпик не должен ссылаться на себя как на подзадачу.");
    }
}