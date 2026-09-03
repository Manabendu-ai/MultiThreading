<h1 align="center">
    MultiThreading For Backend Engineering
</h1>

### Motivation for multithreading
<p>
By default programming languages are sequential in nature.
<br>
Code execution happens linr by line usual scenario.
<br>
Consider the following code:
</p>

```java
public class Runner{
    public static static void main(String[] args) {
        initDB();
        downloadDB();
        processData();
        displayResults();
    }
}
```

Show in the above code snippet we see that all the methods will be called line by line.
<br>Firstly `initDB()` will be invoked, then `downloadDB()`, `processDB()` and finally
`displayResults()` will be called!.
<br>

_But there is Problem here_:
<br>In a single threaded program these instructions will be executed one by one.
The time-consuming sections can freeze the entire application!
<br>

_What's the solution_:
<br>
Figure out the time-consuming tasks and decide if they can be run seperately.
<br>
If yes, then run such task in different thread(s).
<br>

So the change that we can make in the above block of code is to put the `downloadDB()`
in a separate thread as the downloading of data might tke certain time!, and all the other
methods in another thread(). This way we are not freezing the execution of our program.
<br>

### Define Multithreading
Multithreading is the ability of the cpu to perform different tasks concurrently.
