package ua.dp.skillsup.tdd;

import java.time.LocalDate;


public class WeekendService {

    public boolean isWeekend(LocalDate localDate) {
        return (localDate.getDayOfWeek().name().equals("SATURDAY") || localDate.getDayOfWeek().name().equals("SUNDAY"));
    }
}
