package Java8.lambdas;



@FunctionalInterface
interface Person {
    public void getName();
}

public class Client {

    public static void main(String[] args) {

        Person person = new Person() {
            @Override
            public void getName() {
                System.out.println("Name : Person");
            }
        };

        person.getName();

        Runnable r = new Runnable() {
            @Override
            public void run() {
                System.out.println("Runnable");
            }
        };
        new Thread(r).start();


        Runnable r1 = () -> {
            System.out.println("Runnable 1");
        };
        new Thread(r1).start();


        new Thread(()-> System.out.println("runnable 2")).start();



    }
}

