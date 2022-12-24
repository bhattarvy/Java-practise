package thread;

import lombok.Synchronized;

public class Thread2 {


    public static void main(String[] args) {

        System.out.println("Starting the count down example");

        CountDown countDown = new CountDown();
        CountDownThread countDownThread1 = new CountDownThread(countDown);
        countDownThread1.setName("thead 1");

//        Thread thread1 = new Thread(countDownThread);


        CountDownThread countDownThread2 = new CountDownThread(countDown);
        countDownThread2.setName("thread 2");
//        Thread thread2 = new Thread(countDownThread);

        countDownThread2.start();
        countDownThread1.start();


    }

}


class CountDown {
//    private  int i=10;
    public synchronized  static void doCountDown() {

        for(int i=10; i>=1; i--) {
            System.out.println(i + Thread.currentThread().getName());
        }
    }
}

class CountDownThread extends Thread {

    private CountDown countDown;

    public CountDownThread(CountDown countDown){
        this.countDown =countDown;
    }



    @Override
    public void run() {
        /*try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }*/
        countDown.doCountDown();
    }
}