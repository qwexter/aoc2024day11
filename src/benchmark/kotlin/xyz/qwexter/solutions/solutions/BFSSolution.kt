package xyz.qwexter.solutions.solutions

import kotlinx.benchmark.Benchmark
import kotlinx.benchmark.BenchmarkTimeUnit
import kotlinx.benchmark.Mode
import kotlinx.benchmark.Scope
import org.openjdk.jmh.annotations.*
import xyz.qwexter.xyz.qwexter.solutions.DFSSolution
import java.util.concurrent.TimeUnit

@BenchmarkMode(Mode.SingleShotTime)
@OutputTimeUnit(BenchmarkTimeUnit.SECONDS)
@Timeout(time = 2, timeUnit = TimeUnit.HOURS)
@Warmup(iterations = 0, time = 500, timeUnit = BenchmarkTimeUnit.MILLISECONDS)
@Measurement(iterations = 1, time = 1, timeUnit = BenchmarkTimeUnit.SECONDS)
@State(Scope.Benchmark)
open class BFSSolution {

    @Param("25", "45", "55", "60", "75")
    var depth = 0

//    @Benchmark
//    fun dfs() {
//        listOf(0L, 1L, 10L).sumOf {
//            dfs(it, 1, depth.toLong())
//        }
//    }

//    @Benchmark
//    fun bfs_iterative() {
//        BFSSolution.bfsCount(listOf(0L, 1L, 10L), depth.toLong())
//    }

    @Benchmark
    fun dfs_async() {
        DFSSolution.dfsCount(listOf(0L, 1L, 10L), depth.toLong())
    }

//    @Benchmark
//    fun dfs_sync() {
//        DFSSolution.dfsCount2(listOf(0L, 1L, 10L), depth.toLong())
//    }
}