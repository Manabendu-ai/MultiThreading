## Implementing Runnable vs Extends Thread Class

### Which is better approach?
* ### If we extend Thread class we can't extend any other class, usually it is a big disadvantage.
* ### However, a class may implement more than one interface, hence implementing the runnable interface doesn't restrict us to extend other classes.



### What is .join() method in Java Thread?
* Main Thread as the parent thread.
  * When we start a program, usually the execution begins with the main() method.
  * This main() method runs on the main thread, which can be understood as the parent thread since it spawns the other threads.

* Independent execution of threads.
    * When you create and start other threads, they run concurrently with the main thread unless instructed otherwise.
    * So under normal circumstances all the threads run independent of each other. More explicitly no thread waits for other threads.

* what is join()?
* It's allows one thread to pause its execution until another thread (the one it's "joining") has finished.
  In more technical terms, when a thread calls join() on another thread, the calling thread goes into a waiting state until the
  target thread terminates. Once the target thread dies, the waiting thread can resume.