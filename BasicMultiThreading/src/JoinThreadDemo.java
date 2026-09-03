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
        /**
         The actually flow.
         The main method is run by the main thread,
         which is the first thread created by the JVM when the program starts, so it's the first to execute.

         Here the main thread is first creating the objects of t1 and t2 and then when it reaches the t1.start() and t2.start() it puts
         them in the runnable state and then executes the last line (print line).
         Then the cpu becomes free to execute a thread, thereby the threads t1 and t2 are executed at the end.
         */
    }
}
