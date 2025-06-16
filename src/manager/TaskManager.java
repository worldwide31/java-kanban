package manager;

import model.Task;

import java.util.List;

public interface TaskManager {
    int getNextId();
    void addTask(Task task);
    List<Task> getAllTasks();
    Task getTaskById(int id);
    void updateTask(Task task);
    void deleteTaskById(int id);
    void clearTasks();
    void addEpic(model.Epic epic);
    List<model.Epic> getAllEpics();
    model.Epic getEpicById(int id);
    void updateEpic(model.Epic epic);
    void deleteEpicById(int id);
    void clearEpics();
    void addSubtask(model.Subtask subtask);
    List<model.Subtask> getAllSubtasks();
    List<model.Subtask> getSubtasksOfEpic(int epicId);
    void updateSubtask(model.Subtask subtask);
    void deleteSubtaskById(int id);
    void clearSubtasks();
    List<Task> getHistory();
    model.Subtask getSubtaskById(int id); // Добавлен новый метод
}