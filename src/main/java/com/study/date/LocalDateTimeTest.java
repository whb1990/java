package main.java.com.study.date;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoField;
import java.util.Date;

/**
 * @author: whb
 * @date: 2019/7/10 14:44
 * @description: LocalDateTime测试类
 */
public class LocalDateTimeTest {
    public static void main(String[] args) {

        LocalDateTime localDateTime = LocalDateTime.of(2019, Month.JULY, 10, 14, 59, 59);

        DayOfWeek dayOfWeek = localDateTime.getDayOfWeek();
        System.out.println("所在星期：" + dayOfWeek);

        Month month = localDateTime.getMonth();
        System.out.println("月份：" + month);

        long minuteOfDay = localDateTime.getLong(ChronoField.MINUTE_OF_DAY);
        System.out.println(minuteOfDay);

        Instant instant = localDateTime.atZone(ZoneId.systemDefault()).toInstant();

        Date legacyDate = Date.from(instant);
        System.out.println(legacyDate);
    }
}
