package j.u.c.atomic;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author dongfei
 */
public class UserClickCounter {
    ConcurrentHashMap<String,Integer> concurrentHashMap = new ConcurrentHashMap<>();
    ConcurrentHashMap<String, AtomicInteger> concurrentHashMap2 = new ConcurrentHashMap<>();
    AtomicReference<ConcurrentHashMap<String,Integer>> atomicReference = new AtomicReference<>(new ConcurrentHashMap<>());
    ReentrantLock lock = new ReentrantLock();
    public Integer clickWithLock(){
        lock.lock();
        try {
            //concurrentHashMap的get和put分别能保证原子性，但是没有getAndPut的原子性方法，以下代码多线程并发时不能保证原子性
            //如上一个线程设置了17，后面的两个线程都读到了17，导致设置了两个18，预期应该是19
            //加锁后，当前线程获取锁（独占），其他锁不能获取执行临界区内的资源，只能等当前线程执行完释放锁之后才能获取资源
            Integer count = concurrentHashMap.get(Thread.currentThread().getName());
            //锁的话，HashMap应该也OK
            concurrentHashMap.put(Thread.currentThread().getName(), count == null ? 1 : count + 1);
        }finally {
            lock.unlock();
        }
        return concurrentHashMap.get(Thread.currentThread().getName());
    }
    public Integer click(){
        //concurrentHashMap的get和put分别能保证原子性，但是没有getAndPut的原子性方法，以下代码多线程并发时不能保证原子性
        //如上一个线程设置了17，后面的两个线程都读到了17，导致设置了两个18，预期应该是19
        //加锁后，当前线程获取锁（独占），其他锁不能获取执行临界区内的资源，只能等当前线程执行完释放锁之后才能获取资源
        Integer count = concurrentHashMap.get(Thread.currentThread().getName());
        concurrentHashMap.put(Thread.currentThread().getName(), count == null ? 1 : count + 1);
        return concurrentHashMap.get(Thread.currentThread().getName());
    }

    public Integer clickWithAtomicReference(){
        //此种实现毫无意义，跟click没啥区别，对象本身没有变化????
        /** 参见AtomicReference的实现，比较的对象本身没有变化compareAndSet一直都是true
         *     public final V getAndUpdate(UnaryOperator<V> updateFunction) {
         *         V prev, next;
         *         do {
         *             prev = get();
         *             next = updateFunction.apply(prev);
         *         } while (!compareAndSet(prev, next));
         *         return prev;
         *     }
         */
        return atomicReference.getAndUpdate(stringIntegerConcurrentHashMap -> {
            Integer count = stringIntegerConcurrentHashMap.get(Thread.currentThread().getName());
            stringIntegerConcurrentHashMap.put(Thread.currentThread().getName(), count == null ? 1 : count + 1);
            return stringIntegerConcurrentHashMap;
        }).get(Thread.currentThread().getName());
    }

    public Integer clickWithAtomicInteger(){
        concurrentHashMap2.putIfAbsent(Thread.currentThread().getName(),new AtomicInteger(0));
        return concurrentHashMap2.get(Thread.currentThread().getName()).incrementAndGet();
    }
}
