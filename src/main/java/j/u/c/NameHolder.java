package j.u.c;

import lombok.extern.slf4j.Slf4j;

/**
 * @author dongfei
 */
@Slf4j
public class NameHolder {

    public static ThreadLocal<String> stringThreadLocal = new ThreadLocal<>();

    public static void setName(String name){
        log.info("NameHolder SET Thread:{},Name:{}",Thread.currentThread().getName(),name);
        stringThreadLocal.set(name);
    }
    public static String  getName(){
        log.info("NameHolder GET Thread:{},Name:{}",Thread.currentThread().getName(),stringThreadLocal.get());
        return stringThreadLocal.get();
    }
}
