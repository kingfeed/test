package j.u.c;

import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

import javax.xml.ws.Holder;
import java.util.concurrent.Callable;

/**
 * @author dongfei
 */
@Slf4j
@Setter
public abstract class ITask<T> implements Callable<T> {
    private String name;

    public ITask(){
        log.info("ITask created by {}",Thread.currentThread().getName());
        this.name = NameHolder.getName();
    }

    @Override
    public T call() throws Exception {
        NameHolder.setName(name);
        log.info("ITask CALL Thread:{},Name:{}",Thread.currentThread().getName(),name);
        return doIt(name);
    }

    /**
     * 就是干
     * @param who
     * @return
     */
    public abstract T doIt(String who);
}
