package main.advanced.switchDemo;

/*
What does the main function print?
*/
public class SwitchDemo {

    public static void main(String[] args) {

        String command = "X";

        switch(command){
            case "LS": System.out.println("list");
            case "CD": System.out.println("change directory");
            case "RUN": System.out.println("run command");
            default: System.out.println("wrong command");
            case "RM": System.out.println("remove");
        }
    }
}
