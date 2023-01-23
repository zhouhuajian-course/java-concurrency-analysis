package interrupt;

public class Interrupt01 {
    public static void main(String[] args) throws InterruptedException {
        Thread t = new Thread(() -> {
            try {
                Thread.sleep(5000);
                System.out.format("Hello from %s%n", Thread.currentThread().getName());
            } catch (InterruptedException e) {
                System.out.format("%s has been interrupted%n", Thread.currentThread().getName());
            }
        });
        t.start();
        Thread.sleep(3000);
        t.interrupt();
    }
}
