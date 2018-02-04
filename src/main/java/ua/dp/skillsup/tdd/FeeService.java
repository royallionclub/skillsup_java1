package ua.dp.skillsup.tdd;

import org.springframework.beans.factory.InitializingBean;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.time.LocalDate;


public class FeeService implements InitializingBean{

    private HolidayService holidayService;
    private WeekendService weekendService;
    private double fee;

    public void setWeekendService(WeekendService weekendService) {
        this.weekendService = weekendService;
    }

    public void setFee(double fee) {
        this.fee = fee;
    }

    public void setHolidayService(HolidayService holidayService) {
        this.holidayService = holidayService;
    }

    public FeeService() {
    }

    public FeeService(HolidayService holidayService) {
        this.holidayService = holidayService;
    }

    public FeeService(HolidayService holidayService, WeekendService weekendService, double fee) {
        this.holidayService = holidayService;
        this.weekendService = weekendService;
        this.fee = fee;
    }

    public double getFee(double paymentAmount) {
        return fee;
    }



    public double getDayFee() {
        holidayService = new HolidayService();
        weekendService = new WeekendService();
        if(weekendService.isWeekend(LocalDate.now()) && holidayService.isHoliday())
            return 0.02;
        else if ((!weekendService.isWeekend(LocalDate.now()) && holidayService.isHoliday())
                || (weekendService.isWeekend(LocalDate.now()) && !holidayService.isHoliday()))
            return 0.015;
        else
            return 0.01;
    }



    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("FeeService Initialised with fee " + fee);
    }
}
