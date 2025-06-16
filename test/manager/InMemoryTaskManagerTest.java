package manager;

import model.Epic;
import model.Status;
import model.Subtask;
import model.Task;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class InMemoryTaskManagerTest {
    private TaskManager taskManager;

    @BeforeEach
    void setUp() {
        taskManager = new InMemoryTaskManager();
    }

    @Test
    void addNewTask() {
        Task task = new Task(0, "Test addNewTask", "Test addNewTask description", Status.NEW);
        int taskId = taskManager.getNextId();
        task.id = taskId;
        taskManager.addTask(task);

        Task savedTask = taskManager.getTaskById(taskId);

        assertNotNull(savedTask, "Задача не найдена.");
        assertEquals(task, savedTask, "Задачи не совпадают.");

        List<Task> tasks = taskManager.getAllTasks();
        assertNotNull(tasks, "Задачи не возвращаются.");
        assertEquals(1, tasks.size(), "Неверное количество задач.");
        assertEquals(task, tasks.getFirst(), "Задачи не совпадают.");
    }

    @Test
    void getHistory() {
        Task task1 = new Task(0, "Task1", "Desc1", Status.NEW);
        Task task2 = new Task(0, "Task2", "Desc2", Status.NEW);
        task1.id = taskManager.getNextId();
        task2.id = taskManager.getNextId();
        taskManager.addTask(task1);
        taskManager.addTask(task2);

        taskManager.getTaskById(task1.id);
        taskManager.getTaskById(task2.id);

        List<Task> history = taskManager.getHistory();
        assertNotNull(history, "История не должна быть пустой.");
        assertEquals(2, history.size(), "Неверное количество задач в истории.");
        assertTrue(history.contains(task1), "История не содержит первую задачу.");
        assertTrue(history.contains(task2), "История не содержит вторую задачу.");
    }

    @Test
    void addEpicWithSubtasks() {
        Epic epic = new Epic(0, "Epic1", "EpicDesc", Status.NEW);
        epic.id = taskManager.getNextId();
        taskManager.addEpic(epic);

        Subtask subtask = new Subtask(0, "Subtask1", "SubDesc", Status.NEW, epic.id);
        subtask.id = taskManager.getNextId();
        taskManager.addSubtask(subtask);

        Epic savedEpic = taskManager.getEpicById(epic.id);
        assertNotNull(savedEpic, "Эпик не найден.");
        assertEquals(1, savedEpic.getSubtaskIds().size(), "Неверное количество подзадач.");
    }
}