package primenumber.sieve;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import primenumber.PrimeNumberCallback;

public class SieveOfEratosthenesTest {

    private static final long[] GOLDEN_PRIME_NUMBERS = {2, 3, 5, 7, 11, 13, 17, 19, 23, 29};

    @Test
    public void test() {

        int amount = GOLDEN_PRIME_NUMBERS.length;
        PrimeNumberCallbackImpl callback = new PrimeNumberCallbackImpl(amount);
        new SieveOfEratosthenes((int) GOLDEN_PRIME_NUMBERS[amount - 1] + 1).findPrimeNumbers(callback);
        callback.checkAllConsumed();
    }

    private static class PrimeNumberCallbackImpl implements PrimeNumberCallback {

        final int amount;
        int index;

        PrimeNumberCallbackImpl(int amount) {
            this.amount = amount;
        }

        @Override
        public boolean consumeNextPrimeNumber(long primeNumber) {
            Assertions.assertEquals(GOLDEN_PRIME_NUMBERS[index++], primeNumber);
            return index != amount;
        }

        public void checkAllConsumed() {
            Assertions.assertEquals(amount, index);
        }
    }
}
