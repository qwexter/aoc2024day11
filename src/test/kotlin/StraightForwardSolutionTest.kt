import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.Arguments.arguments
import org.junit.jupiter.params.provider.FieldSource
import xyz.qwexter.solutions.StraightForwardSolution
import xyz.qwexter.xyz.qwexter.solutions.BFSSolution
import xyz.qwexter.xyz.qwexter.solutions.DFSSolution

class StraightForwardSolutionTest {

    @ParameterizedTest
    @FieldSource("tesData")
    fun transformations(input: Long, expected: List<Long>) {
        assertEquals(expected, StraightForwardSolution.transform(input))
    }

    @ParameterizedTest
    @FieldSource("tesData")
    fun transformations_opt1(input: Long, expected: List<Long>) {
        assertEquals(expected, StraightForwardSolution.transformOpt1(input))
    }

    @ParameterizedTest
    @FieldSource("tesData")
    fun transformations_opt2(input: Long, expected: List<Long>) {
        assertEquals(expected, StraightForwardSolution.transformOpt2(input))
    }

    @ParameterizedTest
    @FieldSource("testImpl")
    fun calculateSize(impl: (List<Long>, Int) -> Long) {
        val input = listOf(125L, 17)
        val depth = 5

        val actual = impl(input, depth)
        val expected = 22L
        assertEquals(expected, actual)
    }

    companion object {

        @JvmStatic
        private val tesData: List<Arguments> = listOf(
            arguments(0L, listOf(1L)),
            arguments(1L, listOf(2024L)),
            arguments(2024L, listOf(20L, 24L)),
            arguments(2404L, listOf(24L, 4L))
        )



        @JvmStatic
        private val testImpl = listOf(
            arguments(StraightForwardSolution::calculateCount),
            arguments(StraightForwardSolution::calculateCountOpt1),
            arguments(StraightForwardSolution::calculateCountOpt2),
            arguments(BFSSolution::bfsCount),
            arguments(DFSSolution::dfsCount)
        )

    }

}