public class JoinThreadDemo {
    public static void main(String[] args) {
        Thread t1 = new Thread(()->{
            for(int i = 0; i<10; i++){
                System.out.println("Thread One : "+ i);
            }
        });
        Thread t2 = new Thread(()->{
            for(int i = 0; i<30; i++){
                System.out.println("Thread Two : "+ i);
            }
        });

        t1.start();
        t2.start();
        // This print will be executed first bcoz JVM executes the main Thread first(highest priority).
        System.out.println("Finished Execution of thread!");

    }
}
