package TimeTypeTask;

import java.time.LocalDate;

public class OneTime extends Task{
    @Override
    public boolean appearsIn(LocalDate inputDate, LocalDate taskDate) {
        return false;
    }

    @Override
    public void SetNextTime(LocalDate localDate) {
        System.out.println("Задача активна только один раз");
    }
}
