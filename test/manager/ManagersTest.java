package manager;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ManagersTest {
    @Test
    void getDefault() {
        TaskManager manager = Managers.getDefault();
        assertNotNull(manager, "Менеджер не должен быть null.");
        assertInstanceOf(InMemoryTaskManager.class, manager, "Менеджер должен быть экземпляром InMemoryTaskManager.");
    }

    @Test
    void getDefaultHistory() {
        HistoryManager historyManager = Managers.getDefaultHistory();
        assertNotNull(historyManager, "История не должна быть null.");
        assertInstanceOf(InMemoryHistoryManager.class, historyManager, "История должна быть экземпляром InMemoryHistoryManager.");
    }
}