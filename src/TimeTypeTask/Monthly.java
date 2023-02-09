package TimeTypeTask;
import java.time.LocalDate;
public class Monthly extends Task{
    @Override
    public boolean appearsIn(LocalDate inputDate, LocalDate taskDate) {
        return inputDate.getDayOfMonth() == taskDate.getDayOfMonth();
    }

    @Override
    public void nextTimeRunTask(LocalDate localDate) {
        System.out.println("Следующая дата выполнения задачи: " + localDate.plusMonths(1) + "\n");
    }
}
