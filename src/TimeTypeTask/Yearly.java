package TimeTypeTask;

import java.time.LocalDate;

public class Yearly extends Task{
    @Override
    public boolean appearsIn(LocalDate inputDate, LocalDate taskDate) {
        return inputDate.getDayOfYear() == taskDate.getDayOfYear();
    }
    @Override
    public void nextTimeRunTask(LocalDate localDate) {
        System.out.println("Следующая дата выполнения задачи: " + localDate.plusYears(1) + "\n");
    }
}
