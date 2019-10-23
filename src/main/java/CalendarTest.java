import lombok.extern.slf4j.Slf4j;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * @author dongfei
 */
@Slf4j
public class CalendarTest {
    public static void main(String[] args) throws Exception {
        dateEndStart();
        getFirstDateOfWeek(new Date());
        getLastDateOfWeek(new Date());
        getFirstDateOfMonth(new Date());
        getLastDateOfMonth(new Date());

    }

    private static void dateEndStart() throws ParseException {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date date = simpleDateFormat.parse("2019-10-15");
        Date startDateTime = date;
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(startDateTime);
        calendar.add(Calendar.DAY_OF_MONTH, 1);
        calendar.add(Calendar.MILLISECOND, -1);
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
}
