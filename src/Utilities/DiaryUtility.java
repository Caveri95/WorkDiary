package Utilities;

import TimeTypeTask.Task;
import TimeTypeTask.TimeTypeTask;
import WorkDiary.TaskType;
import java.time.LocalDate;
import java.util.*;

import static Utilities.ScannerUtility.DATE_FORMATTER;
import static Utilities.ScannerUtility.DATE_FORMAT;

public class DiaryUtility {

    private final HashMap<Integer, Task> tasks = new HashMap<>();
    private final ArrayList<Task> deleteTasks = new ArrayList<>();

    public void createTask(){
        System.out.println("Выберите периодичность выполнения задачи\n 1 - на один раз\n " +
                "2 - ежедневная\n 3 - еженедельная\n 4 - ежемесячная\n 5 - ежегодная");
        if (ScannerUtility.scanner.hasNextInt()) {
            int a = ScannerUtility.scanner.nextInt();
            switch (a) {
                case 1:
                    TimeTypeTask type1 = TimeTypeTask.ONETIME;
                    var task1 = type1.newTask();
                    task1.takeData(type1);
                    tasks.put(task1.getId(), task1);
                    System.out.println("Была создана задача: " + task1 + "\n");
                    break;
                case 2:
                    TimeTypeTask type2 = TimeTypeTask.DAILY;
                    var task2 = type2.newTask();
                    task2.takeData(type2);
                    tasks.put(task2.getId(), task2);
                    System.out.println("Была создана задача: " + task2 + "\n");
                    break;
                case 3:
                    TimeTypeTask type3 = TimeTypeTask.WEEKLY;
                    var task3 = type3.newTask();
                    task3.takeData(type3);
                    tasks.put(task3.getId(), task3);
                    System.out.println("Была создана задача: " + task3 + "\n");
                    break;
                case 4:
                    TimeTypeTask type4 = TimeTypeTask.MONTHLY;
                    var task4 = type4.newTask();
                    task4.takeData(type4);
                    tasks.put(task4.getId(), task4);
                    System.out.println("Была создана задача: " + task4 + "\n");
                    break;
                case 5:
                    TimeTypeTask type5 = TimeTypeTask.YEARLY;
                    var task5 = type5.newTask();
                    task5.takeData(type5);
                    tasks.put(task5.getId(), task5);
                    System.out.println("Была создана задача: " + task5 + "\n");
                    break;
                default:
                    System.out.println("Нет задачи такого типа!");
            }
        }
    }

    public void tasksList() {
        System.out.println("Какие задачи хотите посмотреть?\n 1 - все задачи\n 2 - рабочие задачи\n 3 - личные задачи\n 4 - удаленные задачи");
        int a = ScannerUtility.askInt();
        switch (a) {
            case 1:
                if (tasks.size() == 0) {
                    System.out.println("****Список активных задач пуст!\n");
                } else {
                    System.out.println("**** Список активных задач");
                    for (Map.Entry<Integer, Task> value : tasks.entrySet()) {
                        System.out.println(value.getKey() + ", " + value.getValue());
                    }
                    System.out.println("\n");
                }
                break;
            case 2:
                System.out.println("**** Список рабочих задач");
                for (Map.Entry<Integer, Task> value : tasks.entrySet()) {
                    if (value.getValue().getTaskType() == TaskType.WORK) {
                        System.out.println(value.getKey() + ", " + value.getValue());
                    }
                    System.out.println("\n");
                }
                break;
            case 3:
                System.out.println("**** Список личных задач");
                for (Map.Entry<Integer, Task> value : tasks.entrySet()) {
                    if (value.getValue().getTaskType() == TaskType.PERSONAL) {
                        System.out.println(value.getKey() + ", " + value.getValue());
                    }
                    System.out.println("\n");
                }
                break;
            case 4:
                System.out.println("**** Список удаленных задач");
                for (Task deleteTask : deleteTasks) {
                    System.out.println(deleteTask);
                }
                System.out.println("\n");
                break;
        }
    }

    public void getTasksOnDate() {
        System.out.println("Получить задачи на следующую дату");
        LocalDate localDate = inputDate();
        if (tasks.size() == 0) {
            System.out.println("В списке ничего нет");
        }
        for (Map.Entry<Integer, Task> value : tasks.entrySet()) {
            LocalDate taskDate = value.getValue().getDate();
            if (taskDate.equals(localDate) || value.getValue().appearsIn(localDate, taskDate)) {
                System.out.println(value);
            }
        }
    }

    public LocalDate inputDate() {
        Scanner scanner1 = new Scanner(System.in);
        System.out.println(DATE_FORMAT);
        var date = scanner1.next();
        return LocalDate.parse(date, DATE_FORMATTER);
    }

    public void deleteTask(){
        try {
            System.out.println("Введите номер задачи, которую нужно удалить");
            int id = ScannerUtility.askInt();
            checkTaskId(id);
            Task task = tasks.get(id);
            deleteTasks.add(task);
            System.out.println("Задача " + task + " перемещена в список удаленных");
            tasks.remove(id);
        } catch (TaskNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }

    public void helper() {
        System.out.println("Список доступных комманд:\n " +
                "0 - список комманд\n " +
                "1 - создать новую задачу\n " +
                "2 - получить список имеющихся или удаленных задач\n " +
                "3 - удалить задачу\n " +
                "4 - получить задачу на заданный день\n " +
                "5 - получить следующий раз выполнение задачи\n " +
                "6 - выйти из ежедневника");
    }

    public void getNextTimeRun() throws TaskNotFoundException {
        try {
            System.out.println("Введите номер задачи, чтобы посмотреть следующее ее выполнение");
            int id = ScannerUtility.askInt();
            checkTaskId(id);
            Task task = tasks.get(id);
            task.nextTimeRunTask(task.getDate());
        } catch (TaskNotFoundException e) {
            System.out.println(e.getMessage());;
        }
    }

    public static void cheсkData(LocalDate localDate) throws IncorrectDateException {
        if (localDate.isBefore(LocalDate.now())) {
            throw new IncorrectDateException("Введена неактуальная дата. Задаче будет присвоена текущая дата!");
        }
    }

    public  void checkTaskId(int id) throws TaskNotFoundException {
        if (!tasks.containsKey(id)) {
            throw new TaskNotFoundException("!!! в списке нет задачи под номером - " + id + ", попробуйте еще раз!!!\n");
        }
    }
}
