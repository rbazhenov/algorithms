package java_examples;

public class Initialization {
    public static void main(String[] args) {
        Child child = new Child(1);
    }


    static class Child extends Parent {
        static String name;
        static {
            name = "child static name";
            System.out.println(name);
        }

        final int number;
        boolean flag;
        {
            flag = true;
            System.out.println("child field");
        }

        Child(int number) {
            super(number);
            this.number = number;
            System.out.println("child constructor");
        }
    }

    static class Parent {
        static String name;
        static {
            name = "parent static name";
            System.out.println(name);
        }

        final int number;
        boolean flag;
        {
            flag = true;
            System.out.println("parent field");
        }

        Parent(int number) {
            System.out.println("parent constructor");
            this.number = number;
        }
    }
}
