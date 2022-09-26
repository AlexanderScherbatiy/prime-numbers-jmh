package primenumber.sieve;

import org.junit.jupiter.api.Test;

public class InfinitySieveOfEratosthenesTest {

    @Test
    public void test1() {
        test1(new long[]{2});
        test1(new long[]{2, 3});
        test1(new long[]{2, 3, 5});
        test1(new long[]{2, 3, 5, 7});
        test1(new long[]{2, 3, 5, 7, 11});
        test1(new long[]{2, 3, 5, 7, 11, 13});
        test1(new long[]{2, 3, 5, 7, 11, 13, 17});
        test1(new long[]{2, 3, 5, 7, 11, 13, 17, 19});
        test1(new long[]{2, 3, 5, 7, 11, 13, 17, 19, 23});
        test1(new long[]{2, 3, 5, 7, 11, 13, 17, 19, 23, 29});
        test1(new long[]{2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31});
    }

    private void test1(long[] primes) {

        CheckPrimeNumbersCallback callback = new CheckPrimeNumbersCallback(primes);
        new InfinitySieveOfEratosthenes(19).findPrimeNumbers(callback);
        callback.checkAllConsumed();
    }

    @Test
    public void test2() {
        test2(new long[]{2});
        test2(new long[]{2, 3});
        test2(new long[]{2, 3, 5});
        test2(new long[]{2, 3, 5, 7});
        test2(new long[]{2, 3, 5, 7, 11});
        test2(new long[]{2, 3, 5, 7, 11, 13});
        test2(new long[]{2, 3, 5, 7, 11, 13, 17});
        test2(new long[]{2, 3, 5, 7, 11, 13, 17, 19});
        test2(new long[]{2, 3, 5, 7, 11, 13, 17, 19, 23});
        test2(new long[]{2, 3, 5, 7, 11, 13, 17, 19, 23, 29});
        test2(new long[]{2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31});
    }

    private void test2(long[] primes) {

        for (int i = 7; i < 12; i++) {
            CheckPrimeNumbersCallback callback = new CheckPrimeNumbersCallback(primes);
            new InfinitySieveOfEratosthenes(i).findPrimeNumbers(callback);
            callback.checkAllConsumed();
        }
    }
}
