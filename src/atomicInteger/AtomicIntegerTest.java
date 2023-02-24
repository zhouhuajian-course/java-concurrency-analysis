package atomicInteger;

import java.util.concurrent.atomic.AtomicInteger;

// 20000
// thread safe
public class AtomicIntegerTest {
    private static final int THREAD_COUNT = 20;
    public static AtomicInteger count = new AtomicInteger();

    public static void main(String[] args) throws InterruptedException {
        Thread[] threads = new Thread[THREAD_COUNT];
        for (int i = 0; i < THREAD_COUNT; i++) {
            threads[i] = new Thread(new Runnable() {
                @Override
                public void run() {
                    for (int i = 0; i < 1000; i++) {
                        increase();
                    }
                }
            });
            threads[i].start();
        }

        for (Thread thread : threads) {
            thread.join();
        }
        System.out.println(count);
    }

    public static void increase() {
        count.incrementAndGet();
    }
}