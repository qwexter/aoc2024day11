package xyz.qwexter.solutions.solutions

import kotlinx.benchmark.BenchmarkTimeUnit
import kotlinx.benchmark.Mode
import kotlinx.benchmark.Scope
import org.openjdk.jmh.annotations.Benchmark
import org.openjdk.jmh.annotations.BenchmarkMode
import org.openjdk.jmh.annotations.Measurement
import org.openjdk.jmh.annotations.OutputTimeUnit
import org.openjdk.jmh.annotations.Param
import org.openjdk.jmh.annotations.State
import org.openjdk.jmh.annotations.Warmup
import xyz.qwexter.solutions.StraightForwardSolution

@BenchmarkMode(Mode.AverageTime)
@OutputTimeUnit(BenchmarkTimeUnit.MILLISECONDS)
@Warmup(iterations = 3, time = 500, timeUnit = BenchmarkTimeUnit.MILLISECONDS)
@Measurement(iterations = 10, time = 1, timeUnit = BenchmarkTimeUnit.MILLISECONDS)
@State(Scope.Benchmark)
open class StraightForwardSolutionBenchmarks {

//    @Param("35", "40", "45", "50", "55")
    @Param("40")
    var size: Int = 0

    @Benchmark
    open fun benchmark0(): Long {
        return StraightForwardSolution.calculateCount(listOf(0L, 1L, 10L), size)
    }

    @Benchmark
    open fun benchmarkOpt1(): Long {
        return StraightForwardSolution.calculateCountOpt1(listOf(0L, 1L, 10L), size)
    }

    @Benchmark
    open fun benchmarkOpt2(): Long {
        return StraightForwardSolution.calculateCountOpt2(listOf(0L, 1L, 10L), size)
    }
}