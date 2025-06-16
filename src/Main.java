import manager.Managers;
import manager.TaskManager;

import model.Task;
import model.Subtask;
import model.Epic;
import model.Status;

public class Main {
    public static void main(String[] args) {
        TaskManager manager = Managers.getDefault();

        Task task1 = new Task(0, "Переезд", "Планировать переезд", Status.NEW);
        Task task2 = new Task(0, "Уборка", "Организовать уборку дома", Status.IN_PROGRESS);
        manager.addTask(task1);
        manager.addTask(task2);

        Epic epic1 = new Epic(0, "Важный эпик 1", "Эпик для важных задач", Status.NEW);
        manager.addEpic(epic1);
        Subtask subtask1 = new Subtask(0, "Собрать коробки", "Собрать коробки", Status.NEW, epic1.getId());
        Subtask subtask2 = new Subtask(0, "Упаковать кошку", "Упаковать кошку", Status.NEW, epic1.getId());
        manager.addSubtask(subtask1);
        manager.addSubtask(subtask2);

        Epic epic2 = new Epic(0, "Важный эпик 2", "Эпик для второстепенных задач", Status.NEW);
        manager.addEpic(epic2);
        Subtask subtask3 = new Subtask(0, "Задача 1", "Первая задача", Status.IN_PROGRESS, epic2.getId());
        manager.addSubtask(subtask3);

        //Вывод начального состояния
        System.out.println("Эпики: " + manager.getAllEpics());
        System.out.println("Задачи: " + manager.getAllTasks());
        System.out.println("Подзадачи: " + manager.getAllSubtasks());

        //зменение статусов и обновление
        subtask1.setStatus(Status.DONE);
        manager.updateSubtask(subtask1);
        subtask2.setStatus(Status.DONE);
        manager.updateSubtask(subtask2);

        System.out.println("После изменения статусов:");
        System.out.println("Эпик1: " + manager.getEpicById(epic1.getId()));

        //Просмотр задач для заполнения истории
        manager.getTaskById(task1.getId());
        manager.getEpicById(epic1.getId());
        manager.getSubtaskById(subtask1.getId()); // Предполагается, что метод есть в TaskManager
        System.out.println("История просмотров: " + manager.getHistory());

        // Удаление задач
        manager.deleteTaskById(task1.getId());
        manager.deleteEpicById(epic2.getId());

        System.out.println("После удаления:");
        System.out.println("Задачи: " + manager.getAllTasks());
        System.out.println("Эпики: " + manager.getAllEpics());
        System.out.println("Подзадачи: " + manager.getAllSubtasks());
        System.out.println("История просмотров: " + manager.getHistory());
    }
}