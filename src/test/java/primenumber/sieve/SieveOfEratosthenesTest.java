package primenumber.sieve;

import org.junit.jupiter.api.Test;

public class SieveOfEratosthenesTest {

    private static final long[] GOLDEN_PRIME_NUMBERS = {2, 3, 5, 7, 11, 13, 17, 19, 23, 29};

    @Test
    public void test() {

        int amount = GOLDEN_PRIME_NUMBERS.length;
        CheckPrimeNumbersCallback callback = new CheckPrimeNumbersCallback(GOLDEN_PRIME_NUMBERS);
        new SieveOfEratosthenes((int) GOLDEN_PRIME_NUMBERS[amount - 1] + 1).findPrimeNumbers(callback);
        callback.checkAllConsumed();
    }
}
