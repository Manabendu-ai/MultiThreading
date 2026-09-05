import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class ScheduledExecutorDemo {
    public static void main(String[] args) {
        ScheduledExecutorService service = new ScheduledThreadPoolExecutor(1);
        service.scheduleAtFixedRate(new ProbeTask(), 1000,2000, TimeUnit.MILLISECONDS);

        try{
            if(!service.awaitTermination(10000, TimeUnit.MILLISECONDS)){
                service.shutdownNow();
            }
        } catch (InterruptedException e) {
            service.shutdownNow();
        }
        /*
        ScheduledThreadPoolExecutor : Allows you to execute task in the future.
        It is very powerful as it allows to run task at fixed interval and also implements awaitTermination method.
        Which terminates the executor after a fixed time.
         */
    }
}

class ProbeTask implements Runnable{

    @Override
    public void run() {
        System.out.println("Probing endpoints for updates...");
    }
}