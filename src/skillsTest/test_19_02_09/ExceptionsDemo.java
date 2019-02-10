package skillsTest.test_19_02_09;

import org.junit.jupiter.api.Test;

public class ExceptionsDemo {

    @Test
    public void unchecked_error_custom_test() {
        throw new CustomUnchecked();
    }

    @Test
    public void unchecked_runtime_custom_test() {
        throw new CustomUncheckedRuntime();
    }

    @Test
    public void checked_exception_test() throws CustomCheckedException{
        throw new CustomCheckedException();
    }

    @Test
    public void catch_everything_test(){
        try {
            throwSomething(new CustomCheckedException());
            //throwSomething(new CustomUncheckedRuntime());
            //throwSomething(new CustomUnchecked());
        }
        catch (Throwable th){
            System.out.println(th.toString());
        }
    }

    private void throwSomething(Throwable th) throws Throwable{
        throw th;
    }

    void addItem(){

    }
}
