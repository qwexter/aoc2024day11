package xyz.qwexter

object StraightForwardSolution {
    fun calculateCount(initial: List<Long>): Long {
        return 0
    }

    fun transform(item: Long): List<Long> {
        return when {
            item == 0L -> listOf(1L)
            item.toString().length % 2 == 0 -> item.toString().let {
                it.chunked(it.length / 2)
                    .map { partial -> partial.toLong() }
            }

            else -> listOf(item * 2024)
        }
    }
}