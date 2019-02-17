package main.advanced.threads;

public class ThreadsTest {


    public static void main(String[] args) throws InterruptedException {

        System.out.println(getCurrentThreadInfo() + "Start main thread");


        // new thread method 1
        CustomThread1 customThread1 = new CustomThread1();
        customThread1.start();

        // new thread method 2
        CustomRunnable customRunnable = new CustomRunnable();
        Thread customThread2 = new Thread(customRunnable);
        customThread2.start();

        Thread.sleep(3000);

        System.out.println(getCurrentThreadInfo() + "Stop main thread");
    }

    public static String getCurrentThreadInfo() {

        Thread currentThread = Thread.currentThread();
        return String.join(" | ",
                currentThread.getName(),
                "tid=" + currentThread.getId(),
                ""
        );
    }
}
