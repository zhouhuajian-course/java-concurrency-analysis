package atomicInteger;

// 19494, not 20000
// thread not safe
public class IntegerTest {
    private static final int THREAD_COUNT = 20;
    public static int count = 0;

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