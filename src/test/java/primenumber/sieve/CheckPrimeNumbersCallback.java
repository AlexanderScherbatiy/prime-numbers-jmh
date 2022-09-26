package primenumber.sieve;


import primenumber.PrimeNumberCallback;
import org.junit.jupiter.api.Assertions;

public class CheckPrimeNumbersCallback implements PrimeNumberCallback {

    private int index = 0;
    private final long[] goldenPrimes;

    public CheckPrimeNumbersCallback(long[] goldenPrimes) {
        this.goldenPrimes = goldenPrimes;
    }

    @Override
    public boolean consumeNextPrimeNumber(long primeNumber) {
        Assertions.assertEquals(goldenPrimes[index], primeNumber, String.format("index: %d", index));
        index++;
        return index < goldenPrimes.length;
    }

    public void checkAllConsumed() {
        Assertions.assertEquals(goldenPrimes.length, index);
    }
}
