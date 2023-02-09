package TimeTypeTask;
import java.time.LocalDate;
public class Weekly extends Task {
    @Override
    public boolean appearsIn(LocalDate inputDate, LocalDate taskDate) {
        return inputDate.getDayOfWeek() == taskDate.getDayOfWeek();
    }

    @Override
    public void nextTimeRunTask(LocalDate localDate) {
        System.out.println("Следующая дата выполнения задачи: " + localDate.plusWeeks(1) + "\n");
    }
}
