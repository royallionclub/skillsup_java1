package ua.dp.skillsup.tdd;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import java.time.LocalDate;


public class FeeServiceTest {

    FeeService feeService;
    HolidayService holidayService;
    WeekendService weekendService;

    @Before
    public void before(){
        feeService = new FeeService();
        holidayService = new HolidayService();
        weekendService = new WeekendService();
        feeService = Mockito.mock(FeeService.class);
        holidayService = Mockito.mock(HolidayService.class);
        weekendService = Mockito.mock(WeekendService.class);
    }

    @Test
    public void getOrdinaryDayFee() throws Exception {
        Mockito.when(holidayService.isHoliday()).thenReturn(false);
        Mockito.when(weekendService.isWeekend(LocalDate.now())).thenReturn(false);
        feeService.getDayFee();
        Assert.assertEquals(0.01,0.01,0);
    }

    @Test
    public void getDayOffFee() throws Exception {
        Mockito.when(holidayService.isHoliday()).thenReturn(false);
        Mockito.when(weekendService.isWeekend(LocalDate.now())).thenReturn(true);
        feeService.getDayFee();
        Assert.assertEquals(0.015,0.015,0);
    }

    @Test
    public void getHolidayFee() throws Exception {
        Mockito.when(holidayService.isHoliday()).thenReturn(true);
        Mockito.when(weekendService.isWeekend(LocalDate.now())).thenReturn(false);
        feeService.getDayFee();
        Assert.assertEquals(0.015,0.015,0);
    }

    @Test
    public void getHolidayOnWeekendFee() throws Exception {
        Mockito.when(holidayService.isHoliday()).thenReturn(true);
        Mockito.when(weekendService.isWeekend(LocalDate.now())).thenReturn(false);
        feeService.getDayFee();
        Assert.assertEquals(0.02,0.02,0);
    }


}