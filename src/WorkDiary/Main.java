package WorkDiary;

import Utilities.DiaryUtility;
import Utilities.ScannerUtility;
public class Main {

    private static DiaryUtility diaryUtility = new DiaryUtility();

    public static void main(String[] args) {

        boolean run = true;

        while (run) {
            helper();

            if (ScannerUtility.scanner.hasNext()) {
                String cmd = ScannerUtility.askString("Введите команду, для вызова меню помощи введите <<help>> ");
                if ("123456789".contains(cmd) || cmd.equals("help")) {
                    switch (cmd) {
                        case "help":
                            helper();
                            break;
                        case "1":
                            createTask();
                            break;
                        case "2":
                            tasksList();
                            break;
                        case "3":
                            delete();
                            break;
                        case "4":
                            getTasksOnDate();
                            break;
                        case "5":
                            getNextTimeRun();
                            break;
                        case "6":
                            System.out.println("Удачи!");
                            run = false;
                            break;
                        default:
                            System.out.println("Нет такой команды!");
                    }
                } else {
                    System.out.println("Введена неккоректная команда");
                }
            }
        }
    }
    private static void createTask() {
        diaryUtility.createTask();
    }

    private static void tasksList() {
        diaryUtility.tasksList();
    }
    private static void getNextTimeRun() {
        int id = ScannerUtility.askInt("Введите номер задачи, чтобы посмотреть следующее ее выполнение");
        diaryUtility.getNextTimeRun(id);
    }

    private static void getTasksOnDate() {
        System.out.println("Получить задачи на следующую дату");
        diaryUtility.getTasksOnDate();
    }

    private static void helper() {
        System.out.println("Список доступных комманд:\n " +
                "1 - создать новую задачу\n " +
                "2 - получить список имеющихся или удаленных задач\n " +
                "3 - удалить задачу\n " +
                "4 - получить задачу на заданный день\n " +
                "5 - получить следующий раз выполнение задачи\n " +
                "6 - выйти из ежедневника");
    }

    private static void delete() {
        int id = ScannerUtility.askInt("Введите номер задачи, которую нужно удалить");
        diaryUtility.deleteTask(id);
    }
}
