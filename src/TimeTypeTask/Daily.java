package TimeTypeTask;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class Daily extends Task{
    @Override
    public boolean appearsIn(LocalDate inputDate, LocalDate taskDate) {
        return true;
    }

    @Override
    public void nextTimeRunTask() {
        System.out.println("Следующая дата выполнения задачи: " + LocalDate.now().plusDays(1) + "\n");
    }
}
