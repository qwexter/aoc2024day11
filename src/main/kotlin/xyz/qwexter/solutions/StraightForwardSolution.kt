package xyz.qwexter.solutions

import kotlin.math.pow

object StraightForwardSolution {
    fun calculateCount(initial: List<Long>, depth: Int): Long {
        var acc = initial
        0.rangeTo(depth).forEach {
            acc = acc.flatMap { item ->
                transform(item)
            }
        }
        return acc.size.toLong()
    }

    fun transform(item: Long): List<Long> {
        return when {
            item == 0L -> listOf(1L)
            item.toString().length % 2 == 0 -> {
                val str = item.toString()
                str.chunked(str.length / 2)
                    .map { partial -> partial.toLong() }
            }

            else -> listOf(item * 2024)
        }
    }

    fun calculateCountOpt1(initial: List<Long>, depth: Int): Long {
        var acc = initial
        0.rangeTo(depth).forEach {
            acc = acc.flatMap { item ->
                transformOpt1(item)
            }
        }
        return acc.size.toLong()
    }

    fun transformOpt1(item: Long): List<Long> {
        if (item == 0L) return listOf(1L)
        val str = item.toString()
        if (str.length and 1 != 0) return listOf(item * 2024)
        return ArrayList<Long>(2).apply {
            add(str.substring(0, str.length / 2).toLong())
            add(str.substring(str.length / 2, str.length).toLong())
        }
    }

    fun calculateCountOpt2(initial: List<Long>, depth: Int): Long {
        var acc = initial
        0.rangeTo(depth).forEach {
            acc = acc.flatMap { item ->
                transformOpt2(item)
            }
        }
        return acc.size.toLong()
    }

    fun transformOpt2(item: Long): List<Long> {
        if (item == 0L) return listOf(1L)
        val numbersInDigits = item.numberOfDigits()
        if (numbersInDigits and 1 != 0) return listOf(item * 2024)
        val half = numbersInDigits / 2
        val division = 10.0.pow(half.toDouble()).toLong()
        return ArrayList<Long>(2).apply {
            add(item / division)
            add(item % division)
        }
    }

    private fun Long.numberOfDigits(): Int {
        var n = this
        var count = 0
        do {
            n /= 10
            count++
        } while (n != 0L)
        return count
    }
}