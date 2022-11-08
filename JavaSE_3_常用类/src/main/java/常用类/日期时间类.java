package 常用类;

import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.time.temporal.TemporalAccessor;
import java.util.Calendar;
import java.util.Date;

public class 日期时间类 {
    @Test
    public void test1() {
        long time = System.currentTimeMillis();
        System.out.println(time);
    }

    @Test
    public void test2() {
        Date date1 = new Date(); // 使用空参构造创建java.util.Date类对象，打印当前的时间
        System.out.println(date1.toString());
        System.out.println(date1.getTime()); // 把日期对象转换成对应的时间毫秒值
        System.out.println(date1.toLocaleString());// 根据本地格式转换日期对象

        Date date2 = new Date(123456L);// 使用有参构造创建java.util.Date类对象，把毫秒值转成日期对象
        System.out.println(date2.toString());
    }

    @Test
    public void test3() {
        java.sql.Date date = new java.sql.Date(123456L);
        System.out.println(date);
    }

    @Test
    public void test4() throws ParseException {
        // 使用无参构造实例化SimpleDateFormat
        SimpleDateFormat dateFormat1 = new SimpleDateFormat();
        // 格式化：日期—>字符串
        String format1 = dateFormat1.format(new Date());
        System.out.println(format1);
        // 解析：字符串—>日期
        Date parse1 = dateFormat1.parse("20-1-6 下午1:00");
        System.out.println(parse1);

        // 使用无参构造实例化SimpleDateFormat，按照指定的方式格式化和解析
        SimpleDateFormat dateFormat2 = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        // 格式化：日期—>字符串
        String format2 = dateFormat2.format(new Date());
        System.out.println(format2);
        // 解析：字符串—>日期
        Date parse2 = dateFormat2.parse("2020-01-06 01:34:09");
        System.out.println(parse2);
    }

    @Test
    public void test5() {
        //实例化：调用静态方法getInstance();
        Calendar calendar = Calendar.getInstance();

        //常用方法：
        //gettime()：日历类—>Date
        Date time = calendar.getTime();
        System.out.println("当前时间：" + time);

    }

    @Test
    public void test6() {
        // now()：获取当前的日期、时间、日期+时间
        LocalDate time1 = LocalDate.now();
        LocalTime time2 = LocalTime.now();
        LocalDateTime time3 = LocalDateTime.now();

        System.out.println(time1);
        System.out.println(time2);
        System.out.println(time3);

        //of()：设置指定的年、月、日、时、分、秒。没有偏移量
        LocalDateTime of = LocalDateTime.of(2022, 1, 6, 10, 10, 10);
        System.out.println(of);

        //getXxx()：获取相关的属性
        System.out.println(time3.getDayOfMonth());
        System.out.println(time3.getDayOfWeek());
        System.out.println(time3.getMonth());
        System.out.println(time3.getMonthValue());
        System.out.println(time3.getMinute());

        //withXxx()：设置相关的属性
        LocalDateTime time4 = time3.withHour(22);
        System.out.println(time3);
        System.out.println(time4);

        //plusXxx()：增加相关的属性
        LocalDateTime time5 = time3.plusHours(5);
        System.out.println(time3);
        System.out.println(time5);

        //minusXxx()：减少相关的属性
        LocalDateTime time6 = time3.minusHours(5);
        System.out.println(time3);
        System.out.println(time5);
    }
    @Test
    public void test7() {
        //now()：获取本初子午线对应的标准时间
        Instant time1 = Instant.now();
        System.out.println(time1);

        //atOffset()：添加时间的偏移量
        OffsetDateTime time2 = time1.atOffset(ZoneOffset.ofHours(8));
        System.out.println(time2);

        //toEpochMilli()：获取自1970年1月1日0时0分0秒（UTC）开始的毫秒数
        long time3 = time1.toEpochMilli();
        System.out.println(time3);

        //ofEpochMilli()：通过给定的毫秒数，获取Instant示例
        Instant time4 = time1.ofEpochMilli(1641470139866L);
        System.out.println(time4);

    }

    @Test
    public void test8() {
        LocalDateTime date = LocalDateTime.now();
        //（1）使用常量创建DateTimeFormatter
        DateTimeFormatter dtf1 = DateTimeFormatter.ISO_DATE_TIME;
        System.out.println(dtf1.format(date));// 格式化：日期—>字符串
        TemporalAccessor parse1 = dtf1.parse("2020-01-06T20:13:08.006");//解析：字符串—>日期
        System.out.println(parse1);

        //（2）使用MEDIUM类型风格的DateTimeFormatter
        DateTimeFormatter dtf2 = DateTimeFormatter.ofLocalizedDateTime(FormatStyle.MEDIUM);
        System.out.println(dtf2.format(date));// 格式化：日期—>字符串
        TemporalAccessor parse2 = dtf2.parse("2020-01-06T20:13:08.006");//解析：字符串—>日期
        System.out.println(parse2);


        //（3）根据模式字符串来创建DateTimeFormatter格式器
        DateTimeFormatter dtf3 = DateTimeFormatter.ofPattern("yyyy-MM-dd  HH:mm:ss");
        System.out.println(dtf3.format(date));
        TemporalAccessor parse3 = dtf3.parse("2020-01-06T20:13:08.006");//解析：字符串—>日期
        System.out.println(parse3);
    }
}


