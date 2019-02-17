package main.advanced.threads;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.parallel.Execution;
import org.junit.jupiter.api.parallel.ExecutionMode;

// run then sequential or in parallel and check the timing
public class JunitThreadsTest {

    void actions() throws InterruptedException {
        System.out.println("Running actions on thread: "
                + ThreadsTest.getCurrentThreadInfo());

        Thread.sleep(3000);
    }

    @Test
    @Execution(ExecutionMode.CONCURRENT)
    public void actions_test1() throws InterruptedException {
        actions();
    }

    @Test
    @Execution(ExecutionMode.CONCURRENT)
    public void actions_test2() throws InterruptedException {
        actions();
    }

    @Test
    @Execution(ExecutionMode.CONCURRENT)
    public void actions_test3() throws InterruptedException {
        actions();
    }
}
