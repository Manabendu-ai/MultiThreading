public class WaitAndNotify {

    private static final Object LOCK = new Object();
    public static void main(String[] args) {
        Thread t1 = new Thread(()->{
            try {
                one();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });

        Thread t2 = new Thread(()->{
            try {
                two();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

        });

        t1.start();
        t2.start();

    }

    public static void one() throws InterruptedException{
        synchronized (LOCK){
            System.out.println("[LOG] Entered method ONE....");
            LOCK.wait(); // Thread calling this will be suspended
            System.out.println("[LOG] Back in the method ONE...");
        }
    }

    public static void two() throws InterruptedException{
        synchronized (LOCK){
            System.out.println("[LOG] Entered method TWO....");
            LOCK.notify();
            System.out.println("[LOG] Hello after method TWO...");
        }
    }
}
