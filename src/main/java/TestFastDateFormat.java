import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.time.FastDateFormat;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * @author dongfei
 */
@Slf4j
public class TestFastDateFormat {
    public static void main(String[] args) {
        FastDateFormat sdf = FastDateFormat.getInstance("yyyy-MM-dd");
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(1560096000000L);
        log.info("the date = {},the yyyy-MM-dd format = {}",calendar.getTime(),sdf.format(calendar.getTime()));
        List<String> abc = new ArrayList<>();
        log.info("abc size {}",abc.size());
        for(String a : abc) {
            log.info("a={}",a);
        }
    }
}
