package main.advanced.threads;

public class CustomRunnable implements Runnable {


    @Override
    public void run() {
        for(int i = 1; i<=10; i++) {
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println(ThreadsTest.getCurrentThreadInfo() + i);
        }
    }
}
