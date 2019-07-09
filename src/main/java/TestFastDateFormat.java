import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.time.FastDateFormat;

import java.util.*;

/**
 * @author dongfei
 * format的时候根据时区，区域设置不同 同一字符串格式化得到的时间不同
 */
@Slf4j
public class TestFastDateFormat {
    public static void main(String[] args) throws Exception{
        FastDateFormat sdf = FastDateFormat.getInstance("yyyy-MM-dd HH:mm:ss",TimeZone.getTimeZone("GMT"),Locale.getDefault());
        log.info("TimeZone:{}",sdf.getTimeZone());
        Calendar calendar = Calendar.getInstance();
        log.info("TimeZone:{}",calendar.getTimeZone());
        calendar.setTimeZone(TimeZone.getTimeZone("UTC"));
        calendar.setTimeInMillis(1560096000000L);
        log.info("TimeZone:{}",sdf.getTimeZone());
        log.info("TimeZone:{}",calendar.getTimeZone());
        /**
         * FastDateFormat.getInstance("yyyy-MM-dd HH:mm:ss",TimeZone.getTimeZone("GMT"))
         * sdf.parse("2010-10-10 10:10:10") Sun Oct 10 18:10:10 CST 2010 结果多8小时
         * 解释，当前Locale为zh_CN GMT是格林尼治时间 字符串转换为时间的时候，根据当前的Locale增加8了小时  北京时间==（GTM+8）
         * sdf.format(new Date()) 2019-07-09 02:23:17 --new Date() 2019-07-09 10:23:17 结果少8小时
         * new Date() 是系统当前时间即北京时间，format格式化时需要转换为GMT格式，相应的会减少8小时
         */
        log.debug("Date:{}",sdf.parse("2010-10-10 10:10:10"));
        log.debug("new Date():{}",new Date());
        log.debug("String:{}",sdf.format(new Date()));
        log.info("the date = {},the yyyy-MM-dd format = {}",calendar.getTime(),sdf.format(calendar.getTime()));
        List<String> abc = new ArrayList<>();
        log.info("abc size {}",abc.size());
        for(String a : abc) {
            log.info("a={}",a);
        }
    }
}
