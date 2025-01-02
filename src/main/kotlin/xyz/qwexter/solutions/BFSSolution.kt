package xyz.qwexter.xyz.qwexter.solutions

import kotlin.math.pow

fun main() {
    println("Count ${BFSSolution.bfsCount(listOf(125L, 17), 49)}")
}

object BFSSolution {

    fun bfsCount(initeal: List<Long>, depth: Long): Long {
        return initeal.sumOf { lng ->
            bfs(lng, depth)
        }
    }

    fun bfs(item: Long, maxLvl: Long): Long {
        var lvl = 0
        val deque = ArrayDeque<Long>().apply { add(item) }
        while (lvl <= maxLvl) {
            var i = 0
            val dequeSize = deque.size
            println("Level ${lvl} and arraySize ${dequeSize}")
            while (i < dequeSize) {
                i++
                val item = deque.removeFirst()
                if (item == 0L) {
                    deque.add(1L)
                    continue
                }
                val numbersInDigits = item.numberOfDigits()
                if (numbersInDigits and 1 != 0) {
                    deque.add(item * 2024)
                    continue
                }
                val half = numbersInDigits / 2
                val division = 10.0.pow(half.toDouble()).toLong()
                deque.add(item / division)
                deque.add(item % division)
            }
            lvl++
        }
        return deque.size.toLong()
    }

    fun Long.numberOfDigits(): Int {
        var n = this
        var count = 0
        do {
            n /= 10
            count++
        } while (n != 0L)
        return count
    }
}