package task;

import model.Status;
import model.Task;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TaskTest {
    @Test
    void equalsById() {
        Task task1 = new Task(1, "Task1", "Desc1", Status.NEW);
        Task task2 = new Task(1, "Task2", "Desc2", Status.DONE);
        assertEquals(task1, task2, "Задачи с одинаковым id должны быть равны.");
    }
}