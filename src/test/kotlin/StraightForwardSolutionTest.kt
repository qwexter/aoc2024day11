import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import xyz.qwexter.StraightForwardSolution

class StraightForwardSolutionTest {

    @Test
    fun transform() {
        val solution = StraightForwardSolution
        val input = 0L

        val actual = solution.transform(input)
        val expected = listOf(1L)

        assertEquals(expected, actual)

        val actual2 = solution.transform(1L)
        val expected2 = listOf(2024L)
        assertEquals(expected2, actual2)

        val actual3 = solution.transform(12L)
        val expected3 = listOf(1L, 2)
        assertEquals(expected3, actual3)
    }
}