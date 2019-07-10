package main.java.com.study.date;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.time.temporal.ChronoUnit;
import java.util.Locale;

/**
 * @author: whb
 * @date: 2019/7/10 14:34
 * @description: LocalDate测试类
 */
public class LocalDateTest {

    public static void main(String[] args) {
        //今天
        LocalDate today = LocalDate.now();
        //明天
        LocalDate tomorrow = today.plus(1, ChronoUnit.DAYS);
        //昨天
        LocalDate yesterday = tomorrow.minusDays(2);
        System.out.println("今天：" + today);
        System.out.println("明天：" + tomorrow);
        System.out.println("昨天：" + yesterday);
        //从一年，一个月和一天获得一个LocalDate的实例。
        LocalDate independenceDay = LocalDate.of(2019, Month.JULY, 10);
        DayOfWeek dayOfWeek = independenceDay.getDayOfWeek();
        System.out.println("从一年，一个月和一天获得一个LocalDate的实例：" + independenceDay + ",所在星期：" + dayOfWeek);
        //从一年，一个月和一天获得一个LocalDate的实例。
        independenceDay = LocalDate.of(2019, 7, 10);
        System.out.println("从一年，一个月和一天获得一个LocalDate的实例：" + independenceDay);
        //从一年和一年的一年中获得LocalDate的实例。
        independenceDay = LocalDate.ofYearDay(2019, 191);
        //从纪元日数获得一个LocalDate的实例.这将返回一个LocalDate与指定的时代。 EPOCH_DAY是第0天为1970-01-01的简单递增计数。 负数表示较早的日子。
        System.out.println("从一年和一年的一年中获得LocalDate的实例：" + independenceDay);
        independenceDay = LocalDate.ofEpochDay(18000);
        System.out.println("从纪元日数获得一个LocalDate的实例：" + independenceDay);
        independenceDay = LocalDate.parse("2019-07-10");
        System.out.println("从一个文本字符串获取一个LocalDate的实例："+independenceDay);
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofLocalizedDate(FormatStyle.MEDIUM).withLocale(Locale.GERMAN);
        LocalDate date = LocalDate.parse("10.07.2019", dateTimeFormatter);
        System.out.println(date);
    }
}
