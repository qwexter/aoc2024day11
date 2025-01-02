//package xyz.qwexter.solutions.solutions
//
//import kotlinx.benchmark.Benchmark
//import kotlinx.benchmark.BenchmarkMode
//import kotlinx.benchmark.Mode
//import kotlinx.benchmark.Param
//import kotlinx.benchmark.Scope
//import org.openjdk.jmh.annotations.OutputTimeUnit
//import org.openjdk.jmh.annotations.State
//import java.util.concurrent.TimeUnit
//import kotlin.math.abs
//import kotlin.math.ln
//
//@State(Scope.Benchmark)
//@BenchmarkMode(Mode.AverageTime)
//@OutputTimeUnit(TimeUnit.NANOSECONDS)
//open class DigitsCounterApproachBenchmarks {
//
//    @Param("0", "123", "123456789", "9223372036854775807")  // Different test cases including MAX_VALUE
//    private var number: Long = 0L
//
//    @Benchmark
//    open fun benchmarkDivision() = number.countDigitsDivision()
//
//    @Benchmark
//    open fun benchmarkLog() = number.countDigitsLog()
//
//    @Benchmark
//    open fun benchmarkConstant() = number.countDigitsConstant()
//
//    @Benchmark
//    open fun benchmarkBitwise() = number.countDigitsBitwise()
//
//    private fun Long.countDigitsDivision(): Int {
//        var n = this
//        var count = 0
//        do {
//            n /= 10
//            count++
//        } while (n != 0L)
//        return count
//    }
//
//    private fun Long.countDigitsLog(): Int =
//        if (this == 0L) 1 else (ln(abs(toDouble())) / ln(10.0)).toInt() + 1
//
//    private fun Long.countDigitsConstant(): Int {
//        val n = abs(this)
//        return when {
//            n < 10L -> 1
//            n < 100L -> 2
//            n < 1000L -> 3
//            n < 10000L -> 4
//            n < 100000L -> 5
//            n < 1000000L -> 6
//            n < 10000000L -> 7
//            n < 100000000L -> 8
//            n < 1000000000L -> 9
//            n < 10000000000L -> 10
//            n < 100000000000L -> 11
//            n < 1000000000000L -> 12
//            n < 10000000000000L -> 13
//            n < 100000000000000L -> 14
//            n < 1000000000000000L -> 15
//            n < 10000000000000000L -> 16
//            n < 100000000000000000L -> 17
//            n < 1000000000000000000L -> 18
//            else -> 19
//        }
//    }
//
//    private fun Long.countDigitsBitwise(): Int =
//        ((63 - abs(this).countLeadingZeros()) * 1233) shr 12 + 1
//
//    public fun Long.countLeadingZeros(): Int = java.lang.Long.numberOfLeadingZeros(this)
//
//
//}