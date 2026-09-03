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

---
### Daemon and User Threads
* On the basis of surface of execution threads can be divided into two types:
  * Daemon Thread --> usually runs in the background.
  * User Thread --> they are the active threads.
* When a Java Program starts the main thread starts running immediately. We can start child threads from the main thread.
  Main thread is the last thread to get executed under normal circumstances, bcoz it has to perform various shutdown operations.
* Daemon Threads are intended to be helper threads which can run in the background and are of low priority. Eg GC thread.
* Daemon Threads are terminated by the JVM when all other user threads are terminated (done with their execution).
* So under normal conditions, user threads are allowed to terminate once they are done with their execution, however, the daemon threads
  are shutdown by the JVM once all the other threads are done executing.

---
### Thread Priority
* Let's say there are 10 threads in runnable state, however there is only one available cpu, so only one thread can execute at a given time
  and others will have to wait. So who decides which thread gets to run on the CPU. This component is called Thread Scheduler.
* Each Thread has certain priority and under normal circumstances thread with the higher priority gets to run on the cpu.
* Priority value from 1 to 10 can be assigned to any thread. 1 priority is represented as MIN_PRIORITY and 10 is represented as MAX_PRIORITY
  which is the highest priority. By default, the priority of a thread is 5, it's represented as NORM_PRIORITY.
* Thread of the same priority value are executed in FIFO manner. The thread scheduler stores the thread in a queue.
* Even though the priority of main thread is 5 it is the first thread to get executed under any circumstance.