package learnexceptions;

public class MainException {



    public static void main(String[] args) {
        Exception1 excp = Exception1.getException1();
        System.out.println(excp);
        try {
            excp.exceptionCase1();

        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println(e);
        }
        System.out.println("hey this is");
    }

}
