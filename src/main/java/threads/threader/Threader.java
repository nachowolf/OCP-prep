package threads.threader;

class HelloRunnable implements Runnable{

    @Override
    public void run() {
        System.out.println("Hello Runner");
    }
}

class HelloThread extends Thread{
    public void run (){
        System.out.println("Hello Thread");
    }
}


public class Threader {
    public static void main(String[] args) throws InterruptedException {
        Thread.sleep(4000);
        (new Thread(new HelloRunnable())).start();

        (new HelloThread()).start();

    }
}
