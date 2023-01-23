package interrupt;

import java.io.IOException;

public class Interrupt02 {
    public static void main(String[] args) throws InterruptedException {
        Thread t = new Thread(() -> {
            try {
                while (true) {
                    if (Thread.interrupted()) {
                        throw new InterruptedException();
                        // 错误的用法 System.exit() 会把整个程序退出
                    }
                 }
            } catch (InterruptedException e) {
                System.out.format("%s has been interrupted%n", Thread.currentThread().getName());
            }
        });
        t.start();
        Thread.sleep(1000);
        t.interrupt();
        Thread.sleep(3000);
        System.out.printf("Hello from '%s'%n", Thread.currentThread().getName());
    }
}
