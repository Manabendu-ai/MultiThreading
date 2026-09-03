public class ExtendsThreadClass {
    /**
     Let's implement thread by extending Thread class.
     */

    public static void main(String[] args) {
        Thread1 t1 = new Thread1();
        Thread2 t2 = new Thread2();

        t1.start();
        t2.start();
    }
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