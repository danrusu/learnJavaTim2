package main.advanced.threads;

import static java.lang.Thread.sleep;

public class RunnableWithDelay implements Runnable{

    @Override
    public void run() {
        System.out.println("Running actions on thread: "
                + ThreadsTest.getCurrentThreadInfo());

        try {
            // simulate real actions that take 3 seconds
            sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
