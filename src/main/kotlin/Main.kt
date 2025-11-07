package org.example

import kotlinx.coroutines.CoroutineScope

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
fun main() {

//    blockingMain()
//
//    val threads = Threads()
//
//    threads.runInBackgroundThread()
//
//    threads.executor()


    nonBlockingMain()


}

/*
in the below code main thread is blocked for 3 sec
and during this time the application or program cannot do anything else
 */

fun blockingMain() {

   println("Start")

    Thread.sleep(3000)
    println("End")

}

fun nonBlockingMain() {
    println("Start")

    val thread = Thread{
        Thread.sleep(3000)
        println("Background task finished")
    }
    thread.start()
    println("End")
    // join will wait of the background task to finish before continuing execution of main thread (indirectly it is blocking main thread)
    // thread.join()
    println("main is running...")


}