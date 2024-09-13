import cn.hutool.core.date.DateTime;
import cn.hutool.core.date.DateUtil;
import com.alibaba.fastjson.JSON;
import org.junit.Test;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.temporal.WeekFields;
import java.util.*;
import java.util.stream.Collectors;

/**
 * Created by w_zhanghongyi
 * Time 2024/9/10 11:10
 * Desc 文件描述
 */
public class TestCeshiV3 {

	//格式
	public static String layout = "-";
	//月 周最开始格式
	public static String startFormat = "01";
	private static final int YEAR_2023 = 2023;

	@Test
	public void main() {
		int year = 2023;

		int week = 54;

		Calendar calendar = Calendar.getInstance();

		calendar.set(Calendar.YEAR, year);

		Calendar calendar1 = cn.hutool.core.date.DateUtil.beginOfYear(calendar);

		DateTime dateTime = cn.hutool.core.date.DateUtil.beginOfWeek(new Date(calendar1.getTimeInMillis() + 7L * 86400000 * (week - 1)));

		System.out.println(dateTime.getTime());


	}



	@Test
	public void m22() {

//
//		Integer byCycle = getByCycle(1, 1672567790000L);
//		System.err.println(byCycle);

//
//		Integer byCycle = getByCycle(0, 1672567790000L);
//		System.err.println(byCycle);


//		Long start = getStartByCycle(1, 2023);
//		System.err.println(start);
//
//
//		Integer byCycle1 = getByCycle(1, 1725790190000L);
//		System.err.println(byCycle1);

	}

	@Test
	public void m33(){
		String readableContent ="[1,2,3]";
		List<Long> list = JSON.parseArray(readableContent, Long.class);
		System.err.println(list);

	}

	@Test
	//测试+1
	public void ceshiWeek() {
//		long startTime = 1672222190000L;

//		long startTime = 1672567790000L;

//		long startTime = 1724836573000L;

//		long startTime = 1704038400000L;

//		long startTime = 1704038400000L;
//		long startTime = 2019743999000L;
		long startTime = 2019398399000L;
		Integer byCycle1 = getByCycle(0, startTime);
		System.err.println(byCycle1);


		// 将毫秒数转换为Date对象
		Date date = new Date(startTime);

		DateTime dateTime1 = DateUtil.endOfWeek(date);
		System.err.println(dateTime1);
		int year = dateTime1.year();
		int week = dateTime1.weekOfYear();
		Integer integer = Integer.valueOf(year + String.format("%02d", week));
		System.err.println(integer);


	}


	@Test
	public void ceshi22(){
		// 假设给定的开始时间为 1725790190000 毫秒
		long startTime = 1672222190000L;

		// 将毫秒数转换为Date对象
		Date date = new Date(startTime);

		// 获取对应的年份和周数
		int year = DateUtil.year(date);

		int month = DateUtil.month(date);
		System.err.println(month);

		Integer integer = Integer.valueOf(year + String.format("%02d", month + 1 ));
		System.err.println(integer);

		Integer byCycle = getByCycle(1, startTime);
		System.err.println(byCycle);


	}

	@Test
	public void m2222(){
		Integer cycleValue = 202202;
		Long start = getStartByCycle(0, cycleValue);
		System.err.println("老的周开始时间" + start);

	}


	@Test
	public void m11111(){
//		Integer cycleValue = 202201;
		List<Integer> integerList = Arrays.asList(203401);

		for (Integer c: integerList) {
			String time = String.valueOf(c);
			String year = time.substring(0, 4);
			String week = time.substring(4, 6);

			int weekAndMonth = Integer.parseInt(week);

			Date beginOfWeek = DateUtil.beginOfWeek(DateUtil.offsetWeek(DateUtil.parse(year + layout + startFormat + layout + startFormat), weekAndMonth - 1));
			System.err.println("新的周开始时间" + beginOfWeek.getTime());


			Long start = getStartByCycle(0, c);
			System.err.println("老的周开始时间" + start);


		}





	}


	@Test
	public void getTime() {
		List<LocalDate> allWeeks = new ArrayList<>();

		for (int year = 2026; year < 2027; year++) {
			WeekFields weekFields = WeekFields.of(Locale.getDefault());
			LocalDate firstDayOfYear = LocalDate.of(year, 1, 1);
			LocalDate lastDayOfYear = LocalDate.of(year, 12, 31);

			LocalDate date = firstDayOfYear;
			while (date.isBefore(lastDayOfYear) || date.isEqual(lastDayOfYear)) {
				if (date.getDayOfWeek() == DayOfWeek.MONDAY) {
					allWeeks.add(date);
				}
				date = date.plusDays(1);
			}
		}

		List<String> collect = allWeeks.stream().map(LocalDate::toString).collect(Collectors.toList());

		List<Integer> collect1 = collect.stream().map(week -> {

			String dateWithoutHyphen = week.replace("-", "");

			return Integer.valueOf(dateWithoutHyphen);
		}).collect(Collectors.toList());

		System.err.println(collect1.size());

	}



	@Test
	public void getValueTime(){
		List<Integer> list = new ArrayList<>();
		String yearStr = "2025";
		for (int year = 1; year < 55; year++) {
			String s = yearStr + String.format("%02d", year);
			list.add(Integer.valueOf(s));
		}

		System.err.println(list);

	}

	/**
	 * 获取该周期的开始时间
	 *
	 * @param cycleType
	 * @param cycleValue
	 * @return
	 */
	public static Long getStartByCycle(Integer cycleType, Integer cycleValue) {
		if (cycleType == 0) {
			String time = String.valueOf(cycleValue);
			String yearStr = time.substring(0, 4);
			String weekStr = time.substring(4, 6);
			int intYear = Integer.parseInt(yearStr);
			int intWeek = Integer.parseInt(weekStr);
			// 2023年的week数要-1，兼容下
			if (intYear == YEAR_2023 || intYear == 2034) {
				intWeek--;
			}
			Calendar calendar = Calendar.getInstance();
			calendar.set(Calendar.YEAR, intYear);
			calendar.set(Calendar.HOUR_OF_DAY, 0);
			calendar.set(Calendar.MINUTE, 0);
			calendar.set(Calendar.SECOND, 0);
			calendar.set(Calendar.MILLISECOND, 0);
			calendar.set(Calendar.WEEK_OF_YEAR, intWeek);
			calendar.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);
			return calendar.getTimeInMillis();
		}
		if (cycleType == 1) {
			String time = String.valueOf(cycleValue);
			String year = time.substring(0, 4);
			String month = time.substring(4, 6);
			Calendar calendar = Calendar.getInstance();
			calendar.set(Calendar.YEAR, Integer.valueOf(year));
			calendar.set(Calendar.HOUR_OF_DAY, 0);
			calendar.set(Calendar.MINUTE, 0);
			calendar.set(Calendar.SECOND, 0);
			calendar.set(Calendar.MILLISECOND, 0);
			calendar.set(Calendar.MONTH, Integer.valueOf(month) - 1);
			calendar.set(Calendar.DAY_OF_MONTH, calendar.getActualMinimum(Calendar.DAY_OF_MONTH));
			return calendar.getTimeInMillis();
		}
		return null;
	}

	/**
	 * 该时间属于第几周或第几月 周：202152 月：202112
	 *
	 * @param cycleType
	 * @param time
	 * @return
	 */
	public static Integer getByCycle(Integer cycleType, Long time) {
		// 周
		if (cycleType == 0) {
			Calendar calendar = Calendar.getInstance();
			calendar.setFirstDayOfWeek(Calendar.MONDAY);
			calendar.setTime(new Date(time));
			int week = calendar.get(Calendar.WEEK_OF_YEAR);
			int month = calendar.get(Calendar.MONTH) + 1;
			int year = calendar.get(Calendar.YEAR);
			if (month == 12 && week == 1) {
				year++;
			}
			return year * 100 + week;
		}
		// 月
		if (cycleType == 1) {
			Calendar calendar = Calendar.getInstance();
			calendar.setTime(new Date(time));
			int month = calendar.get(Calendar.MONTH) + 1;
			int year = calendar.get(Calendar.YEAR);
			return year * 100 + month;
		}
		return null;
	}


}
