package TimeTypeTask;
import java.time.LocalDate;
import java.time.Period;
import java.time.temporal.ChronoUnit;

public class Weekly extends Task {
    @Override
    public boolean appearsIn(LocalDate inputDate, LocalDate taskDate) {
        return inputDate.getDayOfWeek() == taskDate.getDayOfWeek();
    }

    @Override
    public void nextTimeRunTask() {
        LocalDate localDate = getDate();
        long diff = ChronoUnit.WEEKS.between(localDate, LocalDate.now());
        if (diff >= 1) {
            if (localDate.getDayOfWeek() == LocalDate.now().getDayOfWeek()) {
                System.out.println("Следующая дата выполнения задачи: " + localDate.plusWeeks(diff) + "\n");
            } else {
                System.out.println("Следующая дата выполнения задачи: " + localDate.plusWeeks(diff + 1) + "\n");
            }
        } else {
            System.out.println("Следующая дата выполнения задачи: " + localDate.plusWeeks(1) + "\n");
    }
}
}
