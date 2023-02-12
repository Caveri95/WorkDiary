package TimeTypeTask;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class Monthly extends Task{
    @Override
    public boolean appearsIn(LocalDate inputDate, LocalDate taskDate) {
        return inputDate.getDayOfMonth() == taskDate.getDayOfMonth();
    }

    @Override
    public void nextTimeRunTask() {
        LocalDate localDate = getDate();
        long diff = ChronoUnit.MONTHS.between(localDate, LocalDate.now());
        if (diff >= 1) {
            if (LocalDate.now().getDayOfMonth() == localDate.getDayOfMonth()) {
                System.out.println("Следующая дата выполнения задачи: " + localDate.plusMonths(diff) + "\n");
            } else {
                System.out.println("Следующая дата выполнения задачи: " + localDate.plusMonths(diff + 1) + "\n");
            }
        } else {
            System.out.println("Следующая дата выполнения задачи: " + localDate.plusMonths(1) + "\n");
        }



    }
}
