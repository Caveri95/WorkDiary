package TimeTypeTask;

import Utilities.DiaryUtility;
import Utilities.IncorrectDateException;
import Utilities.ScannerUtility;
import WorkDiary.TaskType;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Objects;

public abstract class Task {

     private String title;
    private TaskType taskType;
    private String description;
    private LocalDate date;
    private LocalTime time;
    private TimeTypeTask timeTypeTask;


    private int id;
    private static int idGenerator = 1;


    public Task() {
        id = idGenerator++;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public TimeTypeTask getTimeTypeTask() {
        return timeTypeTask;
    }

    /*public LocalDateTime getDateTime() {
        return dateTime;
    }*/
    public TaskType getTaskType() {
        return taskType;
    }
    public void setTaskType(TaskType taskType) {
        this.taskType = taskType;
    }
    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public void setTime(LocalTime time) {
        this.time = time;
    }

    public LocalTime getTime() {
        return time;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public void takeData(TimeTypeTask type)  {
        System.out.println("Заголовок");
        title = ScannerUtility.scanner.next();
        System.out.println("Описание задачи");
        description = ScannerUtility.scanner.next();
        System.out.println("Выберите тип задания: ");
        for (TaskType task : TaskType.values()) {
            System.out.println(task);
        }
        taskType = TaskType.valueOf(ScannerUtility.scanner.next());
        try {
            System.out.println("На какую дату назначить задачу? Формат ввода даты: " + ScannerUtility.DATE_FORMAT);
            LocalDate date1 = ScannerUtility.askDate();
            DiaryUtility.cheсkData(date1);
            date = date1;
        } catch (IncorrectDateException e) {
            date = LocalDate.now();
            System.out.println(e.getMessage());
        }
        System.out.println("На какое время назначить задачу? Формат ввода времени: " + ScannerUtility.TIME_FORMAT);
        time = ScannerUtility.askTime();
        timeTypeTask = type;
    }
    public abstract boolean appearsIn(LocalDate inputDate, LocalDate taskDate);
    public abstract void nextTimeRunTask(LocalDate localDate);

    @Override
    public String toString() {
        return  "Заголовок - " + title +
                ", тип задачи - " + taskType +
                ", описание - " + description +
                ", дата - " + date +
                ", время - " + time +
                ", периодичность выполнения - " + timeTypeTask +
                ", номер задачи - " + getId();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Task)) return false;
        Task task = (Task) o;
        return id == task.id &&
                Objects.equals(title, task.title) &&
                taskType == task.taskType &&
                Objects.equals(description, task.description) &&
                Objects.equals(date, task.date) &&
                Objects.equals(time, task.time) &&
                timeTypeTask == task.timeTypeTask;
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, taskType, description, date, time, timeTypeTask, id);
    }
}
