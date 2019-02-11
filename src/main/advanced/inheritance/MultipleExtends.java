package main.advanced.inheritance;

public interface MultipleExtends extends Runnable, Comparable, Cloneable {

    static void main(String[] args) {

        MultipleExtends multipleExtends = new MultipleExtends() {

            @Override
            public int compareTo(Object o) {
                return 0;
            }

            @Override
            public void run() {
                System.out.println("run " + this.getClass().getName());
            }
        };

        multipleExtends.run();
        System.out.println(multipleExtends.compareTo(multipleExtends));         

        System.out.println(multipleExtends instanceof MultipleExtends);
        System.out.println(multipleExtends instanceof Runnable);
        System.out.println(multipleExtends instanceof Comparable);
    }

}
