package j.u.c;

import lombok.extern.slf4j.Slf4j;

import java.math.BigDecimal;

/**
 * @author dongfei
 */
@Slf4j
public class InheritableThreadLocalDemo {

    public static final ThreadLocal<InheritableHelper> demo = new ThreadLocal<InheritableHelper> (){
        @Override
        protected InheritableHelper initialValue() {
            return new InheritableHelper();
        }
    };

    public static final InheritableThreadLocal<String> s = new InheritableThreadLocal<String> (){
        @Override
        protected String initialValue() {
            return "hello";
        }
    };

    /**
     * 18:09:21.226 [main] INFO j.u.c.InheritableThreadLocalDemo - thread:1,value:InheritableHelper(goodsPriceMap={})
     * 18:09:21.238 [main] INFO j.u.c.InheritableThreadLocalDemo - thread:1,value:InheritableHelper(goodsPriceMap={0=0, 1=1})
     * 18:09:21.245 [Thread-0] INFO j.u.c.InheritableThreadLocalDemo - thread:11,value:InheritableHelper(goodsPriceMap={0=0, 1=1})
     * 18:09:22.248 [Thread-0] INFO j.u.c.InheritableThreadLocalDemo - thread:11,value:InheritableHelper(goodsPriceMap={0=0, 1=1, 3=3})
     * 18:09:23.239 [main] INFO j.u.c.InheritableThreadLocalDemo - thread:1,value:InheritableHelper(goodsPriceMap={0=0, 1=1, 2=2, 3=3})
     */

    public static void main(String[] args) throws Exception{
        demo.remove();
        log.info("thread:{},value:{}",Thread.currentThread().getId(),demo.get());
        log.info("thread:{},value:{}",Thread.currentThread().getId(),s.get());
        demo.get().getGoodsPriceMap().put("0",new BigDecimal("0"));

        Thread t2 = new Thread();
        t2.start();
        Thread theThread = new Thread(new Runnable() {
            @Override
            public void run() {
                log.info("thread:{},value:{}",Thread.currentThread().getId(),demo.get());
                log.info("thread:{},value:{}",Thread.currentThread().getId(),s.get());
                demo.get().getGoodsPriceMap().put("3",new BigDecimal("3"));
                s.set("hello world");
                try {
                    Thread.sleep(1000L);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                log.info("thread:{},value:{}",Thread.currentThread().getId(),s.get());
                log.info("thread:{},value:{}",Thread.currentThread().getId(),demo.get());
            }
        });
        theThread.start();
        demo.get().getGoodsPriceMap().put("1",new BigDecimal("1"));
        log.info("thread:{},value:{}",Thread.currentThread().getId(),demo.get());
        log.info("thread:{},value:{}",Thread.currentThread().getId(),s.get());
        try {
            Thread.sleep(2000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        demo.get().getGoodsPriceMap().put("2",new BigDecimal("2"));
        log.info("thread:{},value:{}",Thread.currentThread().getId(),demo.get());
        log.info("thread:{},value:{}",Thread.currentThread().getId(),s.get());
        demo.remove();
        log.info("thread:{},value:{}",Thread.currentThread().getId(),demo.get());
        Thread.sleep(500L);
        demo.get().getGoodsPriceMap().put("100",new BigDecimal("100"));
        log.info("thread:{},value:{}",Thread.currentThread().getId(),demo.get());

    }
}
