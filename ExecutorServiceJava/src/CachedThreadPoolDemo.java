import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CachedThreadPoolDemo {
    public static void main(String[] args) {
        ExecutorService service = Executors.newCachedThreadPool();
        for(int i =0; i<1000; i++){
            service.execute(new Task1(i));
        }
        service.shutdown();
        /*
        Here the task queue can contain one task at max.
        If all threads are busy a new thread is created and task is assigned to that thread.
        If a thread is idle for more than 60 sec. It's killed.
         */
        /*
        cached thread pool --> unlimited thread + no queue
         */
    }
}

class Task1 implements Runnable{
    private final int taskId;

    public Task1(int taskId) {
        this.taskId = taskId;
    }

    @Override
    public void run() {
        System.out.println("Task1 with id: "+this.taskId+" being executed by Thread "+Thread.currentThread().getName());
        try{
            Thread.sleep(500);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}