package synchronization;

public class SynchronizedCounterDemo {

    public static void main(String[] args) throws InterruptedException {
        SynchronizedCounter c = new SynchronizedCounter();
        Thread t1 = new Thread(() -> {
            for (int i = 0; i < 10000; i++) {
                c.increment();
            }
        });
        Thread t2 = new Thread(() -> {
            for (int i = 0; i < 10000; i++) {
                c.decrement();
            }
        });
        t1.start();
        t2.start();

        t1.join();
        t2.join();
        // 0 结果符合预期
        System.out.println(c.value());
    }
}


