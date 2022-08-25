package primenumber.sieve;

import primenumber.PrimeNumberCallback;

public class SieveOfEratosthenes {

    private final int sieveSize;
    private final boolean[] array;

    public SieveOfEratosthenes(int sieveSize) {
        this.sieveSize = sieveSize;
        this.array = new boolean[sieveSize];
    }

    public void findPrimeNumbers(PrimeNumberCallback callback) {

        int startIndex = 2;

        while (startIndex < sieveSize) {
            if (!array[startIndex]) {
                if (!callback.consumeNextPrimeNumber(startIndex)) {
                    return;
                }

                int index = startIndex;
                while (index < sieveSize) {
                    array[index] = true;
                    index += startIndex;
                }
            }
            startIndex++;
        }
    }
}
