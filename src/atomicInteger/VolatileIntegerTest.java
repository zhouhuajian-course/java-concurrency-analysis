package atomicInteger;

// volatile关键字很重要的两个特性:
// 1、保证变量在线程间可见，对volatile变量所有的写操作都能立即反应到其他线程中，换句话说，volatile变量在各个线程中是一致的（得益于java内存模型—"先行发生原则"）；
// 2、禁止指令的重排序优化；
// 这个论据并不能得出"基于volatile变量的运算在并发下是安全的"这个结论，因为核心点在于java里的运算（比如自增）并不是原子性的
// 19717, not 20000
// thread not safe
public class VolatileIntegerTest {
    private static final int THREAD_COUNT = 20;
    public static volatile int count = 0;

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
        count++;
    }
}