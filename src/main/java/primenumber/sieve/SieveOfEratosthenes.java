package primenumber.sieve;

import primenumber.PrimeNumberCallback;

public class SieveOfEratosthenes {

    private final int sieveSize;
    private final boolean[] mark;

    public SieveOfEratosthenes(int sieveSize) {
        this.sieveSize = sieveSize;
        this.mark = new boolean[sieveSize];
    }

    public void findPrimeNumbers(PrimeNumberCallback callback) {

        int startIndex = 2;

        while (startIndex < sieveSize) {
            if (!mark[startIndex]) {
                if (!callback.consumeNextPrimeNumber(startIndex)) {
                    return;
                }

                int index = startIndex;
                do {
                    mark[index] = true;
                    index += startIndex;
                } while (index < sieveSize);
            }
            startIndex++;
        }
    }
}
