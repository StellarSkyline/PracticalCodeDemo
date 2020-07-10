package com.example.practicalcodedemo

import org.junit.Test

import org.junit.Assert.*
import kotlin.random.Random
import kotlin.random.nextInt

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest {

    fun get2Largest(list: ArrayList<Int>):Pair<Int, Int>{
        var x = 2
        var y = 1

        for(i in 0 until list.size) {
            if(x <list[i]) {
                y = x
                x = list[i]
            } else if(y < list[i] && list[i] != x) {
                y = list[i]
            }
        }

        return Pair(x,y)
    }

    fun shuffle(deck:ArrayList<Int>):ArrayList<Int> {

        var x = 0
        var y = 0
        var z = 0



        for(i in 0 until deck.size) {
            var random = Random.nextInt(51)
            if(z != random) {
                z = random
            }
            x = deck[i]
            y = deck[z]
            deck[z] = x
            deck[i] = y

        }

        return deck
    }

    @Test
    fun test1() {
        var list:ArrayList<Int> = ArrayList()
        list.add(8)
        list.add(15)
        list.add(23)
        list.add(67)
        list.add(10)

        println("2 Largest: " + get2Largest(list))
    }

    @Test
    fun test3() {
        var deck:ArrayList<Int> = ArrayList()

        for( i in 0..51) {
            deck.add(i+1)
        }

        println("Un-Shuffled Deck: "+deck)

        println("Shuffled Deck: " + shuffle(deck))

    }
}