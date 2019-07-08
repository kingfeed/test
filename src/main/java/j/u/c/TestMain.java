package j.u.c;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.*;

/**
 * @author dongfei
 */
@Slf4j
public class TestMain {
    private final static ExecutorService executorService = new ThreadPoolExecutor(3,9,0L,
            TimeUnit.MILLISECONDS,new LinkedBlockingQueue<Runnable>(1024), Executors.defaultThreadFactory());

    public static void main(String[] args){
        NameHolder.setName("james");
        String currentName = NameHolder.getName();
        for(int i =0; i< 10; i++) {
            if(i>6){
                NameHolder.setName("holiday");
            }
            executorService.submit(new ITask<String>() {
                @Override
                public String doIt(String who) {
                    log.info("ITask DO Thread:{},Name:{}",Thread.currentThread().getName(),who);
                    return null;
                }
            });
        }
    }
}
