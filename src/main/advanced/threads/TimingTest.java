package main.advanced.threads;

import org.junit.jupiter.api.Test;

// run all tests and check the timing for each one
public class TimingTest {

    RunnableWithDelay r1 = new RunnableWithDelay();
    RunnableWithDelay r2 = new RunnableWithDelay();
    RunnableWithDelay r3 = new RunnableWithDelay();


/*    public static void main(String[] args) {
        RunnableWithDelay r1 = new RunnableWithDelay();
        RunnableWithDelay r2 = new RunnableWithDelay();
        RunnableWithDelay r3 = new RunnableWithDelay();
        r1.run();
        r2.run();
        r3.run();
        System.out.println("Finished main thread");
    }*/


    @Test
    public void single_thread_test() throws InterruptedException {
        System.out.println("Single threaded:");
        r1.run();
        r2.run();
        r3.run();
        System.out.println();
    }

    @Test
    public void three_threads_test() throws InterruptedException {

        System.out.println("Concurent on 3 threads:");

        Thread t1 = new Thread(r1);
        t1.start();

        Thread tLambda = new Thread(() -> {
            System.out.println("***" + ThreadsTest.getCurrentThreadInfo());
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        tLambda.start();


        Thread t2 = new Thread(r1);
        t2.start();

        Thread t3 = new Thread(r1);
        t3.start();

        // wait for all threads to finish running
        t1.join();
        t2.join();
        t3.join();
        tLambda.join();
    }
}
