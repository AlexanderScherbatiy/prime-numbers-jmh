package primenumber.sieve;

import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.BenchmarkMode;
import org.openjdk.jmh.annotations.Fork;
import org.openjdk.jmh.annotations.Measurement;
import org.openjdk.jmh.annotations.Mode;
import org.openjdk.jmh.annotations.Param;
import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.Setup;
import org.openjdk.jmh.annotations.State;
import org.openjdk.jmh.annotations.Warmup;
import org.openjdk.jmh.infra.Blackhole;
import primenumber.PrimeNumberCallback;

import java.util.concurrent.TimeUnit;

@BenchmarkMode(Mode.AverageTime)
@Warmup(iterations = 5, time = 1, timeUnit = TimeUnit.SECONDS)
@Measurement(iterations = 5, time = 1, timeUnit = TimeUnit.SECONDS)
@Fork(1)
@State(Scope.Benchmark)
public class SieveOfEratosthenesJMH {

    @Param({"1000000", "10000000", "100000000", "1000000000"})
    int sieveSize;

    private SieveOfEratosthenes sieveOfEratosthenes;

    @Setup
    public void setup() {
        sieveOfEratosthenes = new SieveOfEratosthenes(sieveSize);
    }

    @Benchmark
    public void testSieveOfEratosthenes(Blackhole blackhole, BlackHokePrimeNumberCallback callback) {
        callback.setBlackhole(blackhole);
        sieveOfEratosthenes.findPrimeNumbers(callback);
    }

    @State(Scope.Thread)
    public static class BlackHokePrimeNumberCallback implements PrimeNumberCallback {

        Blackhole blackhole;

        public void setBlackhole(Blackhole blackhole) {
            this.blackhole = blackhole;
        }

        @Override
        public boolean consumeNextPrimeNumber(long primeNumber) {
            blackhole.consume(primeNumber);
            return true;
        }
    }
}
