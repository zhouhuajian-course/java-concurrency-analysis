package interrupt;

import java.io.IOException;

public class Interrupt02 {
    public static void main(String[] args) throws InterruptedException {
        Thread t = new Thread(() -> {
            while (true) {
                // 如果没有这个检查，即使线程状态为被中断状态，也会继续运行
                if (Thread.interrupted()) {
                    System.out.format("%s has been interrupted%n", Thread.currentThread().getName());
                    System.exit(1);
                }
             }
        });
        t.start();
        Thread.sleep(3000);
        t.interrupt();
    }
}
