package org.example.concurrency

import kotlinx.coroutines.delay
import kotlin.coroutines.resume
import kotlin.coroutines.resumeWithException
import kotlin.coroutines.suspendCoroutine

/*
 1. kotlin coroutines are language level feature designed to simplify asynchronous programming and concurrency.
 2. coroutines is a light-weight co-operative unit of work that can be paused and resumed later without blocking main thread.
 3. unlike thread, a coroutine does not necessarily run concurrently on a separate cpu core
 4. coroutines follow structured concurrency it means coroutines are launched in a specific scope and their lifecycle is unmanaged so that you can avoid leaks and unexpected behaviors.
 */

class Coroutines {






    suspend fun fetchData() : Int{
        delay(1000)
        return -1
    }

    /*

    suspendCoroutine lets u pause a coroutine at a specific point and manually decide when it should continue.
    this makes ideal turing callback-based api's into suspend functions

     */

    // if u call this fun then end is not printed because the code not stopped running
    suspend fun playGame() {
        println("Start")

        suspendCoroutine<Unit> { continuation ->

        }

        println("end")

    }


    suspend fun networkRequest() {
        println("Start..")
        delay(1000)
        val result = suspendCoroutine<String> { continuation ->
            // sending network request
            // receiving data

            // sending it back to result
            continuation.resume(value = "network data")

        }

        println("End $result")

    }

    suspend fun networkRequest(apikey : String) {
        println("Start..")
        delay(1000)
        val result = suspendCoroutine<String> { continuation ->
            // sending network request
            // receiving data
            if (apikey.length !in 10..15){
                continuation.resumeWithException(Exception("Invalid API Key"))
            }else{
                continuation.resume(value = "network data")
            }


        }

        println("End $result")

    }

}