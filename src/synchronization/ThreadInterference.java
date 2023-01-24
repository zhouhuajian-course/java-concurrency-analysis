package synchronization;

public class ThreadInterference {

    public static void main(String[] args) throws InterruptedException {
        Counter c = new Counter();
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
        // -15 结果不符合预期
        // 如果没有线程干扰，那么值应该为0
        System.out.println(c.value());
    }
}


