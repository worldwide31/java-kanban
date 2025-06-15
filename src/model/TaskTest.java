package model;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class TaskTest {

    @Test
    void tasksWithSameIdShouldBeEqual() {
        Task first  = new Task(1, "t1", "d1", Status.NEW);
        Task second = new Task(1, "other", "other", Status.DONE);

        assertEquals(first, second,
                "Экземпляры Task с одинаковыми id должны быть равны.");
        assertEquals(first.hashCode(), second.hashCode(),
                "hashCode() обязан совпадать при равенстве id.");
    }

    @Test
    void tasksWithDifferentIdShouldNotBeEqual() {
        Task first  = new Task(1, "t1", "d1", Status.NEW);
        Task second = new Task(2, "t1", "d1", Status.NEW);

        assertNotEquals(first, second,
                "Экземпляры Task с разными id не должны быть равны.");
    }
}
