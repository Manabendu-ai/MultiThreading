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
            LOCK.wait(); // Thread calling this will be suspended and it will move in a waiting state
            System.out.println("[LOG] Back in the method ONE...");
        }
    }
    /*
    Key difference between wait and sleep methods:
    1) wait method is used for inter thread communication and synchronization purpose.
    2) sleep method is used to pause the execution of a thread for a specific duration of time.
     */
    public static void two() throws InterruptedException{
        synchronized (LOCK){
            System.out.println("[LOG] Entered method TWO....");
            LOCK.notify(); // This is release the lock and notify other threads that they can acquire this lock.
            // this .notify() will execute after executing the synchronized block, i.e. whatever is after the noity() will be executed
            // and then only the lock will be released.
            System.out.println("[LOG] Hello after method TWO...");
        }
    }
}
