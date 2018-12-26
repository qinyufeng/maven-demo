package com.qyf.maven_demo.utils.Date;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.DayOfWeek;
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public final class DateUtils {
	/** 日期格式 **/
	public interface DATE_MODEl {
		String HHMMSS = "HHmmss";
		String HH_MM_SS = "HH:mm:ss";
		String YYYYMMDD = "yyyyMMdd";
		String YYYY_MM_DD = "yyyy-MM-dd";
		String YYYYMMDDHHMMSS = "yyyyMMddHHmmss";
		String YYYYMMDDHHMMSSSSS = "yyyyMMddHHmmssSSS";
		String YYYY_MM_DD_HH_MM_SS = "yyyy-MM-dd HH:mm:ss";
		String YYYY_MM_DD_HH_MM_SS_SSS = "yyyy-MM-dd HH:mm:ss.SSS";
		String YY="yy";
		String YYMMDD = "yyMMdd";
		String YY_MM_DD = "yy-MM-dd";
	}
	public static void main(String[] args) throws ParseException {
	}
	
	public static final String getDateStr(Object date, String pattern) {
		if (date == null) {
			return null;
		}
		if (pattern == null) {
			return new SimpleDateFormat("yyyyMMdd").format(date);
		}else if(pattern.equals(DATE_MODEl.YY)) {
			return new SimpleDateFormat(pattern).format(date);
		}else if(pattern.equals(DATE_MODEl.YY_MM_DD)) {
			return new SimpleDateFormat(pattern).format(date);
		}else if(pattern.equals(DATE_MODEl.YYMMDD)) {
			return new SimpleDateFormat(pattern).format(date);
		}else if(pattern.equals(DATE_MODEl.YYYY_MM_DD)) {
			return new SimpleDateFormat(pattern).format(date);
		}else if(pattern.equals(DATE_MODEl.YYYY_MM_DD_HH_MM_SS)) {
			return new SimpleDateFormat(pattern).format(date);
		}else if(pattern.equals(DATE_MODEl.YYYY_MM_DD_HH_MM_SS_SSS)) {
			return new SimpleDateFormat(pattern).format(date);
		}else if(pattern.equals(DATE_MODEl.YYYYMMDD)) {
			return new SimpleDateFormat(pattern).format(date);
		}else if(pattern.equals(DATE_MODEl.YYYYMMDDHHMMSS)) {
			return new SimpleDateFormat(pattern).format(date);
		}else if(pattern.equals(DATE_MODEl.YYYYMMDDHHMMSSSSS)) {
			return new SimpleDateFormat(pattern).format(date);
		}else if(pattern.equals(DATE_MODEl.HHMMSS)) {
			return new SimpleDateFormat(pattern).format(date);
		}else if(pattern.equals(DATE_MODEl.HH_MM_SS)) {
			return new SimpleDateFormat(pattern).format(date);
		}
		return new SimpleDateFormat(pattern).format(date);
	}
	private void javaTime8() throws ParseException {
		/********************获取日期和时间***********************/
		LocalDate date = LocalDate.now();//只存储了日期 比如：2018-12-10
		LocalTime time = LocalTime.now();//只存储了时间，如：15:52:24.785 (后面的.785表示毫秒值的最后三位使用.withNano(0)可把毫秒值设为0,如LocalTime.now().withNano(0)
		LocalTime time2 = LocalTime.now().withNano(0);//15:52:24
		LocalDateTime dateTime=LocalDateTime.now();//存储了日期和时间，比如：2018-12-10T16:03:52.900
		/******************** Date 转 String***********************/
		//旧的API 使用Date和SimpleDateFormat
        SimpleDateFormat simpleDateFormat = 
                        new SimpleDateFormat("G yyyy年MM月dd号 E a hh时mm分ss秒");
        String format1 = simpleDateFormat.format(new Date());
        System.out.println(format1);  //打印: 公元 2017年03月21号 星期二 下午 06时38分20秒
     
        //使用jdk1.8 LocalDateTime和DateTimeFormatter
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter pattern = 
                   DateTimeFormatter.ofPattern("G yyyy年MM月dd号 E a hh时mm分ss秒");
        String format2 = now.format(pattern);
        
        System.out.println(format2); //打印: 公元 2017年03月21号 星期二 下午 06时38分20秒
        /******************** String 转  Date***********************/
        //使用Date和SimpleDateFormat
        SimpleDateFormat simpleDateFormat2 = 
                  new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        Date strTodate1 = simpleDateFormat2.parse("2018-12-3 10:15:30");//月份03可以写成3
        //使用jdk1.8 LocalDateTime和DateTimeFormatter
        DateTimeFormatter pattern2 = 
                    DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDateTime dt = LocalDateTime.parse("2018-12-03 10:15:30",pattern2); //严格按照ISO yyyy-MM-dd验证，03写成3都不行
        /******************** 日期加减 ***********************/
        dateTimeAddOrSubtract();      
        /********************  判断当前日期属于星期几 ***********************/
        dayOfWeek(LocalDateTime.now());
	}
	/**
	 * 日期加减
	 */
	private void dateTimeAddOrSubtract() {
		String dateStr="2018-12-10";
		LocalDate paramDate = LocalDate.parse(dateStr,DateTimeFormatter.ofPattern("yyyy-MM-dd"));
		paramDate.minusDays(1);//日期减一天
		paramDate.plusDays(1);//日期加一天
        LocalDateTime dateTime = LocalDateTime.now();
        //改变时间后会返回一个新的实例nextYearTime
        LocalDateTime nextYearTime = dateTime.plusYears(1);//年份增加一年
        LocalDateTime brefYearTime = dateTime.minusYears(1);//年份减一年
        LocalDateTime nextMothTime=dateTime.plusMonths(1);//月份加一月
        LocalDateTime brefMothTime=dateTime.minusMonths(1);//月份减一月
        LocalDateTime nextDateTime = dateTime.plusDays(1);//日期增加一天
        LocalDateTime brefDateTime = dateTime.minusDays(1);//日期减一天
      //自定义时间，使用with方法设置月份
        LocalDateTime time = LocalDateTime.of(2018, 1, 1, 1, 1,1);
        LocalDateTime changeTime = time.withMonth(12);
        System.out.println(changeTime); //2018-12-01T01:01:01
	}
	/**
	 *       判断当前日期属于星期几
	 * @param time
	 * @return 星期（一、二、三、四、五、六、日)
	 */
	private String dayOfWeek(LocalDateTime time) {
       // LocalDateTime time = LocalDateTime.now();
        DayOfWeek dayOfWeek = time.getDayOfWeek();
        System.out.println(dayOfWeek);
        if("MONDAY".equals(dayOfWeek.toString())) return "星期一";
        if("TUESDAY".equals(dayOfWeek.toString())) return "星期二";
        if("WEDNESDAY".equals(dayOfWeek.toString())) return "星期三";
        if("THURSDAY".equals(dayOfWeek.toString())) return "星期四";
        if("FRIDAY".equals(dayOfWeek.toString())) return "星期五";
        if("SATURDAY".equals(dayOfWeek.toString())) return "星期六";
        if("SUNDAY".equals(dayOfWeek.toString())) return "星期日";
        return "";
	}
	/**
	 *  java.time.Duration
	 *           此类用来计算两同类型日期的时间差
	 */
	private void durationTime() {
		String timeStr="2018-12-11 00:00:00";
		LocalDateTime start = LocalDateTime.parse(timeStr, DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
		LocalDateTime end = start.plusDays(1);

		 Duration result = Duration.between(start, end);
		 System.out.println(result.toDays()); //1
		 System.out.println(result.toHours()); //24
		 System.out.println(result.toMinutes()); //1440
		 System.out.println(result.toMillis()); //86400000
		 System.out.println(result.toNanos()); //86400000000000
	}
}
