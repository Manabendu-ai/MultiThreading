import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**

 The Producer-Consumer problem is a synchronization scenario where one or more producer threads generate data and put into
 shared buffer, while one or more consumer threads retrieve and process the data from the buffer concurrently.


 */
class Worker{
    private int sequence = 0;
    private final int TOP = 5;
    private final int BOTTOM = 0;
    private final LinkedList<Integer> container = new LinkedList<>();
    private final Object LOCK =  new Object();


    public void produce() throws InterruptedException {
        synchronized (LOCK){
            while (true){
                if(container.size()==TOP){
                    System.out.println("Container is full! Waiting for the consumer to consume it.");
                    LOCK.wait();
                } else{
                    System.out.println(sequence+" Added to the container!");
                    container.add(sequence++);
                    LOCK.notify(); // this doesn't come into the picture immediately
                }
                Thread.sleep(1000);
            }
        }

    }

    public void consume(){
        synchronized (LOCK){
            while(true){
                if(container.size()==BOTTOM){
                    System.out.println("Container is empty! Waiting for the producer to produce.");
                }else{
                    System.out.println(container.removeFirst()+" Consumed by the container");
                    LOCK.notify();
                }
            }
        }
    }
}
public class ProducerConsumer {

    public static void main(String[] args) {

    }
}
