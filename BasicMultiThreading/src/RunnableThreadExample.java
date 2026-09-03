
public class RunnableThreadExample {

    /**
     Implementing basic multithreading using Runnable interface.
     */

    public static void main(String[] args) {
        Thread t1 = new Thread(new ThreadOne());
        Thread t2 = new Thread(new ThreadTwo());
        Thread t3 = new Thread(() -> {
            for(int i=0; i<15; i++){
                System.out.println("Thread Three : "+ i);
            }
        });

        t1.start();
        t2.start();
        t3.start();
    }

    /**
     analysis the output :
     We see that the programs are not executed in a sequence it is in a random order of execution.
     So what happenend?
     --> We create 2 threads, t1 and t2 (NEW state)
     --> when we start the two threads with .start() method, JVM puts the two threads into RUNNABLE or RUNNING state.
     --> Once the thread schedular finds the available spot for a particular thread to run on the cpu.
     --> It is assigned to the cpu, that's the time it is running.
     --> For the time the thread is not assigned to a cpu, the thread has to wait. That is the main reason we are seeing
     a random order of execution.
     */
}

class ThreadOne implements Runnable{
    @Override
    public void run(){
        for(int i=0; i<15; i++){
            System.out.println("Thread One : "+ i);
        }
    }
}

class ThreadTwo implements Runnable{
    @Override
    public void run(){
        for(int i=0; i<15; i++){
            System.out.println("Thread Two : "+ i);
        }
    }
}
