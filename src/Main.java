public class Main {
    public static void main(String[] args) {
        (new Thread(() -> {
            System.out.println("Hello from a thread!");
        })).start();
        System.out.println("Hello world!");
    }
}