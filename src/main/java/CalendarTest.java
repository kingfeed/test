import lombok.extern.slf4j.Slf4j;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * @author dongfei
 */
@Slf4j
public class CalendarTest {



    public static void main(String[] args) throws Exception {
        /**
        dateEndStart();
        getFirstDateOfWeek(new Date());
        getLastDateOfWeek(new Date());
        getFirstDateOfMonth(new Date());
        getLastDateOfMonth(new Date());
         **/
        List<Date> dateArrayList = new ArrayList<>();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        dateArrayList.add(simpleDateFormat.parse("2019-10-01"));
        dateArrayList.add(simpleDateFormat.parse("2019-10-05"));
        dateArrayList.add(simpleDateFormat.parse("2019-10-06"));
        dateArrayList.add(simpleDateFormat.parse("2019-10-10"));
        dateArrayList.add(simpleDateFormat.parse("2019-10-20"));
        dateArrayList.add(simpleDateFormat.parse("2019-02-28"));
        dateArrayList.add(simpleDateFormat.parse("2019-09-10"));
        dateArrayList.add(simpleDateFormat.parse("2019-09-30"));
        dateArrayList.add(simpleDateFormat.parse("2019-08-31"));
        dateArrayList.add(simpleDateFormat.parse("2019-08-05"));
        dateArrayList.add(simpleDateFormat.parse("2019-07-05"));
        dateArrayList.add(simpleDateFormat.parse("2019-02-29"));

        log.info("the month day = {}",getLastDayOfMonthFilterByMonth(dateArrayList));
        log.info("the week day = {}",getLastWeekDayFilterByWeek(dateArrayList));

    }

    private static void dateEndStart() throws ParseException {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date date = simpleDateFormat.parse("2019-10-15");
        Date startDateTime = date;
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(startDateTime);
        calendar.add(Calendar.DAY_OF_MONTH, 1);
        calendar.add(Calendar.SECOND, -1);
        Date endDateTime = calendar.getTime();
        log.info("startTime = {}",startDateTime);
        log.info("endTime = {}",endDateTime);
    }

    /**
     * 获取某一天所在周的第一天
     * @param date
     * @return
     */
    public static Date getFirstDateOfWeek(Date date){
        log.info("current date = {}",date);
        Calendar calendar = Calendar.getInstance();
        calendar.setFirstDayOfWeek(Calendar.MONDAY);
        calendar.setTime(date);
        calendar.set(Calendar.DAY_OF_WEEK,Calendar.MONDAY);
        log.info("first day of week = {}",calendar.getTime());
        return calendar.getTime();
    }

    /**
     * 获取某一天所在周的最后一天
     * @param date
     * @return
     */
    public static Date getLastDateOfWeek(Date date){
        Calendar calendar = Calendar.getInstance();
        calendar.setFirstDayOfWeek(Calendar.MONDAY);
        calendar.setTime(date);
        calendar.set(Calendar.DAY_OF_WEEK,Calendar.SUNDAY);
        log.info("last day of week + {}",calendar.getTime());
        return calendar.getTime();
    }

    /**
     * 获取某一天所在月的最后一天
     * @param date
     * @return
     */
    public static Date getLastDateOfMonth(Date date){
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.MONTH,1);
        calendar.set(Calendar.DAY_OF_MONTH,0);
        log.info("first day of month + {}",calendar.getTime());
        return calendar.getTime();
    }

    /**
     * 获取某一天所在月的最后一天
     * @param date
     * @return
     */
    public static Date getFirstDateOfMonth(Date date){
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.set(Calendar.DAY_OF_MONTH,1);
        log.info("last day of month + {}",calendar.getTime());
        return calendar.getTime();
    }

    /**
     * 过滤日期
     * 过滤历史周期
     * 周过滤
     *
     * @param sourceDateList
     * @return
     */
    public static Set<Date> getLastWeekDayFilterByWeek(List<Date> sourceDateList) {
        // 目标日期
        Set<Date> targetDateSet = new HashSet<>();
        Set<Date> filter = new HashSet<>();
        Date currentDate = new Date();
        //系统当前时间所在周的周一
        Date firstWeekDayOfCurrentDate = getFirstDateOfWeek(new Date());
        for (Date date : sourceDateList) {
            // 求传入日期所在周的最后一天
            Date lastDateOfWeek = getLastDateOfWeek(date);
            //如果不是当前周的日期，就有再算一遍的机会
            if (!targetDateSet.contains(date)
                    && !filter.contains(lastDateOfWeek)
                    && (date.compareTo(firstWeekDayOfCurrentDate) < 0)) {
                targetDateSet.add(date);
                filter.add(lastDateOfWeek);
            }
        }
        return targetDateSet;
    }

    /**
     * 过滤日期
     * 过滤历史周期
     * 月过滤
     *
     * @param sourceDateList
     * @return
     */
    public static Set<Date> getLastDayOfMonthFilterByMonth(List<Date> sourceDateList) throws Exception {
        // 过滤月（月末）
        Set<Date> targetDateSet = new HashSet<>();
        Set<Date> filter = new HashSet<>();
        Date currentDate = new Date();
        //系统当前时间所在月的第一天
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date firstMonthDayOfCurrentDate = getFirstDateOfMonth(simpleDateFormat.parse(simpleDateFormat.format(new Date())));
        for (Date date : sourceDateList) {
            // 求传入日期所在月的最后一天
            Date lastDateOfMonth = getLastDateOfMonth(date);
            // 如果日期没有出现过，并且是历史周期
            if (!targetDateSet.contains(date)
                    && !filter.contains(lastDateOfMonth)
                    && (date.compareTo(firstMonthDayOfCurrentDate) < 0)) {
                targetDateSet.add(date);
                filter.add(lastDateOfMonth);
            }
        }
        return targetDateSet;
    }
}
