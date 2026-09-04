/**
 We have created a counter variable and incrementing it with two thread t1 and t2 each of them running till 10000.
 But we see that the output not 20000. The reason for this behavior is non-atomic operation.

 See our main task it to increment the counter variable:
 counter = counter + 1
 But under the hood it is actually in three steps:
 1) load the variable from the memory : counter
 2) inccrement the actual count : counter + 1
 3) assigning back to the counter : counter = counter + 1
 So suppose if the Thread t1 loads the counter varaible first,
 It sees that the value is 0 and then increments to 1 and assigns back.
 But in between of this operation Thread 2 also might pick the counter variable at 0 and incr and assogn back.
 Therefore, there lies an inconsistency among the values.
 counter = 0; incrementValue = 1; <- Thread One
 counter = 0; incrementValue = 1; <- Thread Two

 This is called race condition, in technical terms.
 When we have a shared resource, and multiple thread working on the same shared resource and these kind of scenarios
 lead to inconsistency which is called race condition.

 To avoid such kind of scenarios we can ensure that at a given time only one thread has the access to the shared resource.
 So that way we can achieve that the shared resource is not being occupied by more than one thread at a time.
 This is called Mutual exclusion.
 */

public class SynchronisationDemo {

    private static int counter1 = 0;
    private static int counter2 = 0;

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

        try{
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println("Counter value: "+counter1+" -- "+counter2);
    }
    /*
    synchronized keyword tell JVM that at a given instant of time not more than one thread must be able to access this method.
     */
    private synchronized static void increment1(){
        // critical section
        counter1++;
    }
    /*
    Now we see that we are getting the expected output that is 20000.
     */
    private synchronized static void increment2(){
        // critical section
        counter2++;
    }
    /*
    See here both the threads t1 and t2 are associated with different synchronized methods inc1 and inc2.
    But their is small issue here. see the t2 also have to wait until t1 completes it execution because:
    synchronized method uses a class level lock.
    No matter how many synchronized methods are there in a class all of them will have to share the same class level lock.
    So other threads which have no means with the other synchronized block will have to wait for their turn to acquire that lock.
    here:
    if thread1 is executing first it will acquire the class level lock from the inc1() method and start executing.
    But thread2 is also now waiting for that lock acquired by thread to enter into it's block that is inc2().
    Which is unnecessary because thread has a complete different task to perform.
    This is the major drawback of using synchronized at the method level.
     */
}
