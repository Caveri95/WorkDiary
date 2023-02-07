package WorkDiary;

import Utilities.DiaryUtility;
import Utilities.ScannerUtility;
import Utilities.TaskNotFoundException;

public class Main {

    private static  DiaryUtility diaryUtility = new DiaryUtility();

    public static void main(String[] args) throws TaskNotFoundException {

        lable:
        while (true) {
            diaryUtility.helper();
            if (ScannerUtility.scanner.hasNextInt()) {
                int cmd = ScannerUtility.askInt("Выберите нужный пункт");

                switch (cmd) {
                    case 0:
                        diaryUtility.helper();
                        break;
                    case 1:
                        diaryUtility.createTask();
                        break;
                    case 2:
                        diaryUtility.tasksList();
                        break;
                    case 3:
                        diaryUtility.deleteTask();
                        break;
                    case 4:
                        diaryUtility.getTasksOnDate();
                        break;
                    case 5:
                        diaryUtility.getNextTimeRun();
                        break;
                    case 6:
                        break lable;
                    default:
                        System.out.println("Неизвестная команда!");
                }
            } else {
                ScannerUtility.scanner.next();
                System.out.println("Выберите пункт из меню");
            }
        } System.out.println("Удачи!");
    }
}
