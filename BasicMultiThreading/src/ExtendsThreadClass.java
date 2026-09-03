public class ExtendsThreadClass {
    /**
     Let's implement thread by extending Thread class.
     */
}

class Thread1 extends Thread{
    @Override
    public void run(){
        for (int i = 0; i < 15; i++) {
            System.out.println("Thread One : "+i);
        }
    }
}


class Thread2 extends Thread{
    @Override
    public void run(){
        for (int i = 0; i < 15; i++) {
            System.out.println("Thread Two : "+i);
        }
    }
}