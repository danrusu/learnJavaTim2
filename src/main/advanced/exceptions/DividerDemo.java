package main.advanced.exceptions;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/*
 * This class must display the result if operation is possible,
 * or print a warning message otherwise.
 *
 * */
public class DividerDemo {

    @Test
    public void positive_test() throws Exception {

        final float result = new Divider(90, 5).getResult();
        Assertions.assertEquals(18, result);
        System.out.println(result);
    }

    @Test
    public void negative_test() {
        Assertions.assertThrows(
                Exception.class,
                () -> new Divider(90, 0).getResult());
    }


    @Test
    public void real_world_test() {
        try {
            System.out.println("90 / 5");
            System.out.println(new Divider(90, 5).getResult());

            System.out.println("90 /0");
            new Divider(90, 0).getResult();

        } catch (DivisionByZeroException e) {
            System.out.println(e.getMessage());
        }
    }
}
