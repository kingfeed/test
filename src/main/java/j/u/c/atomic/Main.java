package j.u.c.atomic;

import com.alibaba.fastjson.JSON;

/**
 * @author dongfei
 */
public class Main {
    public static void main(String[] args) throws InterruptedException {
        System.out.println(Thread.currentThread().getName());
        ClickCounter clickCounter = new ClickCounter();
        UserClickCounter userClickCounter = new UserClickCounter();
        UserClickCounter userClickCounter2 = new UserClickCounter();
        UserClickCounter userClickCounter3 = new UserClickCounter();
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                for(int i=0;i<10;i++) {
                    try {
                        Thread.sleep(10L);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getName()+"-------click:------"+clickCounter.click());
                }
            }
        };

        Runnable runnable2 = new Runnable() {
            @Override
            public void run() {
                for(int i=0;i<10;i++) {
                    try {
                        Thread.sleep(10L);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getName()+"-------click:------"+userClickCounter.click());
                    System.out.println(Thread.currentThread().getName()+"-------clickWithLock:------"+userClickCounter2.clickWithLock());
                    System.out.println(Thread.currentThread().getName()+"-------clickWithAtomicReference:------"+userClickCounter3.clickWithAtomicReference());
                    System.out.println(Thread.currentThread().getName()+"-------clickWithAtomicInteger:------"+userClickCounter3.clickWithAtomicInteger());

                }
            }
        };

        for(int i =0; i< 10;i++){
            Thread t = new Thread(runnable,"thread----"+(i+1));
           // t.start();
        }
        for(int i =0; i< 10;i++){
            Thread t = new Thread(runnable2,"thread----user");
            t.start();
        }
        Thread.sleep(1000L);
        System.out.println(Thread.currentThread().getName()+"-------click:------"+clickCounter.click());
        System.out.println(Thread.currentThread().getName()+"-------click:------"+ JSON.toJSONString(userClickCounter.concurrentHashMap));
        System.out.println(Thread.currentThread().getName()+"-------clickWithLock:------"+ JSON.toJSONString(userClickCounter2.concurrentHashMap));
        System.out.println(Thread.currentThread().getName()+"-------clickWithAtomicReference:------"+ JSON.toJSONString(userClickCounter3.atomicReference.get()));
        System.out.println(Thread.currentThread().getName()+"-------clickWithAtomicInteger:------"+ JSON.toJSONString(userClickCounter3.concurrentHashMap2));
    }
}
