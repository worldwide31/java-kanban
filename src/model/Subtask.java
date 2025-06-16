package model;

public class Subtask extends Task {
    private final int epicId;

    public Subtask(int id, String title, String description, Status status, int epicId) {
        super(id, title, description, status);
        if (id == epicId) {
            throw new IllegalArgumentException("Подзадача не может быть своим же эпиком.");
        }
        this.epicId = epicId;
    }

    public int getEpicId() {
        return epicId;
    }
}