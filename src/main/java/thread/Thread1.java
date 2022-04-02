package thread;

public class Thread1 extends Thread {

    @Override
    public void run() {
        System.out.println("it is thread 1 ");
        for(int i=0; i<10; i++)
            System.out.println(i);
        try {
            sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
