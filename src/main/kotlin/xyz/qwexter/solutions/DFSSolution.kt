package xyz.qwexter.xyz.qwexter.solutions

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.awaitAll
import kotlinx.coroutines.runBlocking
import xyz.qwexter.xyz.qwexter.solutions.BFSSolution.numberOfDigits
import kotlin.math.pow

object DFSSolution {

    fun dfsCount(initial: List<Long>, depth: Long): Long {
        return runBlocking {
            initial.map { input ->
                async(Dispatchers.Default) {
                    dfs(input, depth)
                }
            }.awaitAll()
                .sum()
        }
    }

    fun dfsCount2(initial: List<Long>, depth: Long): Long {
        return initial.sumOf { input ->
            dfs(input, depth)
        }
    }

//    fun dfs(item: Long, depth: Long): Long {
//        val stack = ArrayDeque<Pair<Long, Int>>().apply {
//            add(item to 0)
//        }
//        var totalNodes = 1L
//        while (stack.isNotEmpty()) {
//            val (current, level) = stack.removeLast()
//            if (level >= depth) continue
//            when {
//                current == 0L -> {
//                    stack.add(1L to level + 1)
//                }
//
//                current.numberOfDigits() and 1 != 0 -> {
//                    stack.add(current * 2024 to level + 1)
//                }
//
//                else -> {
//                    val half = current.numberOfDigits() / 2
//                    val division = 10.0.pow(half.toDouble()).toLong()
//                    // Add children in reverse order so the left branch is processed first
//                    stack.add(current % division to level + 1)
//                    stack.add(current / division to level + 1)
//                    totalNodes++
//                }
//            }
//        }
//
//        return totalNodes
//    }

    fun dfs(item: Long, maxLvl: Long): Long {
        fun dfsHelper(current: Long, level: Long): Long {
            // Base case - if we've reached max level, stop recursing
            if (level >= maxLvl) return 0L

            // Process current node based on conditions
            return when {
                current == 0L -> {
                    // For 0, convert to 1 and continue down that path
                    dfsHelper(1L, level + 1)
                }

                current.numberOfDigits() and 1 != 0 -> {
                    // For odd number of digits, multiply by 2024
                    dfsHelper(current * 2024, level + 1)
                }

                else -> {
                    // For even number of digits, split the number
                    val half = current.numberOfDigits() / 2
                    val division = 10.0.pow(half.toDouble()).toLong()

                    // Recurse on both halves and add 2 for the current splits
                    2L + dfsHelper(current / division, level + 1) +
                            dfsHelper(current % division, level + 1)
                }
            }
        }

        // Start the recursion from level 0
        return dfsHelper(item, 0)
    }
}