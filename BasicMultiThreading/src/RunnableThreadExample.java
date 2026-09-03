
public class RunnableThreadExample {

    /**
     Implementing basic multithreading using Runnable interface.
     */
}

class ThreadOne implements Runnable{
    @Override
    public void run(){
        for(int i=0; i<5; i++){
            System.out.println("Thread One : "+ i);
        }
    }
}
