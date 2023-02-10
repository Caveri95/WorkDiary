package TimeTypeTask;

import java.time.LocalDate;

public class Daily extends Task{
    @Override
    public boolean appearsIn(LocalDate inputDate, LocalDate taskDate) {
        return true;
    }

    @Override
    public void nextTimeRunTask() {
        //System.out.println("Следующая дата выполнения задачи: " + localDate.plusDays(1) + "\n");
    }
}
