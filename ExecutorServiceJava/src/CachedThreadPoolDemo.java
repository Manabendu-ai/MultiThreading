import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CachedThreadPoolDemo {
    public static void main(String[] args) {
        ExecutorService service = Executors.newCachedThreadPool();
        for(int i =0; i<1000; i++){
            service.execute(new Task1(i));
        }
        service.shutdown();
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