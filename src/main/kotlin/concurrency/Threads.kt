package org.example.concurrency

import java.util.concurrent.Executors

/*
* threads can run in parallel
* creating too many threads is expensive (every thread uses memory and cpu)
* executors resue thread pools
* (since using many threads leads to app unresponsive, to handel it developers have also used
   the executors which is a thread pool that reuses a fixed no of threads)
 */

class Threads {


    fun runInBackgroundThread() {

        //background work here
        Thread{
            println(
                "Running on thread : ${Thread.currentThread().name}"
            )
        }.start()

    }

    fun executor() {

        val executor = Executors.newFixedThreadPool(2)

        executor.execute {
            println("Task 1 on ${Thread.currentThread().name}")
        }

        executor.execute {
            println("Task 2 on ${Thread.currentThread().name}")
        }

        executor.shutdown()

    }

}