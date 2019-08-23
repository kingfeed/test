package j.u.c.atomic;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author dongfei
 */
public class ClickCounter {
    private AtomicInteger clickCount = new AtomicInteger();

    public Integer click(){
        return clickCount.getAndIncrement();
    }
}
