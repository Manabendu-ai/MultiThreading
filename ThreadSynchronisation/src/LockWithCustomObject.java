public class LockWithCustomObject {

    private static int counter1 = 0;
    private static int counter2 = 0;

    /**
     * Here we have made 2 locks lock1 and lock2 for two different critical blocks inc1 and inc2 respectively.
     * Now the thread2 should not wait to acquire the lock because here the locks are not common or shared.
     */
    private static final Object lock1 = new Object();
    private static final Object lock2 = new Object();

    public static void main(String[] args) {
        Thread t1 = new Thread(()->{
            for (int i = 0; i < 10000; i++) {
                increment1();
            }
        });
        Thread t2 = new Thread(()->{
            for (int i = 0; i < 10000; i++) {
                increment2();
            }
        });
        t1.start();
        t2.start();


        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println("Counter : "+counter1+" -- "+counter2);
    }
    private static void increment1(){
        synchronized (lock1){
            counter1++;
        }
    }
    private static void increment2(){
        synchronized (lock2){
            counter2++;
        }
    }
}
