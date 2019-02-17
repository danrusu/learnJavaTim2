package main.advanced.threads;

public class CustomThread1 extends Thread {

    @Override
    public void run(){

        System.out.println("Start CustomThread1 thread");

        for(int i = 1; i<=10; i++) {
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println(ThreadsTest.getCurrentThreadInfo() + i);
        }

        System.out.println("Stop CustomThread1 thread");
    }

}
