## What is an Executor Service?
> Executor Service is a tool in Java that is used to managing and running tasks concurrently across multiple threads.
> The Executor Service is an interface provided by the java.util.concurrent.
> <br>It helps us in creating a pool of threads.
> <br>The threads are not killed once they are done executing there tasks, rather they are reused to execute another tasks.

### Drawbacks of creating manual Thread?
> It requires a lot of memory. (a single thread in java can take upto 512kb to 1mb of memory).
> In manual creation after a thread completes it's execution it gets terminated instead of being reused.
> context switching overhead.
> Time consuming process.

### key features of executor service:
> Thread Pooling: Reuses existing threads, reducing overhead of thread creation and destruction.
> Task Submission: Allows tasks to be submitted for execution using methods like execute() and submit().
> Graceful Shutdown: Provides methods (shutdown() and shutdownNow()) to terminate the executor service gracefully or immediately.

### There are four types of executor service
* SingleThreadExecutor
* FixedThreadPoolExecutor
* CachedThreadPool
* ScheduledExecutor
---
_execute()_ : The execute() method is part of the Executor interface in Java.
It is used to submit a task for execution. The method does not return any result or feedback about the task's completion.

_submit()_ : The submit() method is a way to send a task (like a job or operation) to an ExecutorService for execution.
This method is like telling a worker to do a job, but it’s different from just giving them the job and not expecting any feedback.

<img src="assests/exevssub.png">

### Working of executor service

<img src="assests/executor-service.png" width="60%">

---

<img src="assests/executor.png" width="40%">


