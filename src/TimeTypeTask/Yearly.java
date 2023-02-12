package TimeTypeTask;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class Yearly extends Task {
    @Override
    public boolean appearsIn(LocalDate inputDate, LocalDate taskDate) {
        return inputDate.getDayOfYear() == taskDate.getDayOfYear();
    }

    @Override
    public void nextTimeRunTask() {
        LocalDate localDate = getDate();
        long diff = ChronoUnit.YEARS.between(localDate, LocalDate.now());
        if (diff >= 1) {
            if (LocalDate.now().getDayOfYear() == localDate.getDayOfYear()) {
                System.out.println("Следующая дата выполнения задачи: " + localDate.plusYears(diff) + "\n");
            } else {
                System.out.println("Следующая дата выполнения задачи: " + localDate.plusYears(diff + 1) + "\n");
            }
        } else {
            System.out.println("Следующая дата выполнения задачи: " + localDate.plusYears(1) + "\n");
        }
    }
}
