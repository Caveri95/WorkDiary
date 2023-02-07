package TimeTypeTask;

import java.time.LocalDate;

public class Yearly extends Task{
    @Override
    public boolean appearsIn(LocalDate inputDate, LocalDate taskDate) {
        return inputDate.getDayOfMonth() == taskDate.getDayOfMonth() &&
                inputDate.getMonth() == taskDate.getMonth();
    }
    @Override
    public void SetNextTime(LocalDate localDate) {
        System.out.println("Следующая дата выполнения задачи: " + localDate.plusYears(1) + "\n");
    }
}
