package Utilities;

import TimeTypeTask.Task;
import TimeTypeTask.TimeTypeTask;
import WorkDiary.TaskType;
import java.time.LocalDate;
import java.util.*;

public class DiaryUtility {

    HashMap<Integer, Task> tasks = new HashMap<>();
    ArrayList<Task> deleteTasks = new ArrayList<>();

    public void createTask() {

        int a = ScannerUtility.askInt("Выберите периодичность выполнения задачи\n 1 - на один раз\n " +
                "2 - ежедневная\n 3 - еженедельная\n 4 - ежемесячная\n 5 - ежегодная");

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

    public void tasksList() {
        int a = ScannerUtility.askInt("Какие задачи хотите посмотреть?\n 1 - все задачи\n 2 - рабочие задачи\n 3 - личные задачи\n 4 - удаленные задачи");
        switch (a) {
            case 1:
                if (tasks.size() == 0) {
                    System.out.println("****Список активных задач пуст!\n");
                } else {
                    System.out.println("**** Список активных задач");
                    for (Map.Entry<Integer, Task> value : tasks.entrySet()) {
                        System.out.println("Номер задачи - " + value.getKey() + ", " + value.getValue());
                    }
                    System.out.println("\n");
                }
                break;
            case 2:
                System.out.println("**** Список рабочих задач");
                for (Map.Entry<Integer, Task> value : tasks.entrySet()) {
                    if (value.getValue().getTaskType() == TaskType.WORK) {
                        System.out.println("Номер задачи - " + value.getKey() + ", " + value.getValue());
                    }
                    System.out.println("\n");
                }
                break;
            case 3:
                System.out.println("**** Список личных задач");
                for (Map.Entry<Integer, Task> value : tasks.entrySet()) {
                    if (value.getValue().getTaskType() == TaskType.PERSONAL) {
                        System.out.println("Номер задачи - " + value.getKey() + ", " + value.getValue());
                    }
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

    public void getTasksOnDate() throws TaskNotFoundException {
        LocalDate localDate = inputDate();
        if (tasks.size() == 0) {
            System.out.println("В списке ничего нет");
        }
        try {
            for (Map.Entry<Integer, Task> value : tasks.entrySet()) {
                LocalDate taskDate = value.getValue().getDate();

                if (!taskDate.equals(localDate) || !value.getValue().appearsIn(localDate, taskDate)) {
                    throw new TaskNotFoundException("Задач на эту дату нет!");
                } else System.out.println(value);
            }
        } catch (Exception e) {
            throw new TaskNotFoundException(e.getMessage());
        }
    }

    public LocalDate inputDate() {
        Scanner scanner1 = new Scanner(System.in);
        System.out.println("Узнать задачи на следующую дату\n Введите день");
        int a = scanner1.nextInt();
        System.out.println("Введите месяц");
        int b = scanner1.nextInt();
        System.out.println("Введите год");
        int c = scanner1.nextInt();
        return LocalDate.of(c, b, a);
    }

    public void deleteTask(int id) throws TaskNotFoundException {
        try {
            if (!tasks.containsKey(id)) {
                throw new TaskNotFoundException("!!! в списке нет задачи под номером " + id + ", попробуйте еще раз!!!\n");
            }
            Task task = tasks.get(id);
            deleteTasks.add(task);
            System.out.println("Задача " + task + " перемещена в список удаленных");
            tasks.remove(id);
        } catch (TaskNotFoundException e) {
            System.out.println(e.getMessage());
        }


    }

    public void getNextTimeRun(int id) {
        Task task = tasks.get(id);
        task.SetNextTime(task.getDate());


    }
}
