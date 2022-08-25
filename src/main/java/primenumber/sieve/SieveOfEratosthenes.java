package primenumber.sieve;

import primenumber.PrimeNumberCallback;

public class SieveOfEratosthenes {

    private final int size;
    private final boolean[] array;

    public SieveOfEratosthenes(int size) {
        this.size = size;
        this.array = new boolean[size];
    }

    public void findPrimeNumbers(PrimeNumberCallback callback) {

        int startIndex = 2;

        while (startIndex < size) {
            if (!array[startIndex]) {
                if (!callback.consumeNextPrimeNumber(startIndex)) {
                    return;
                }

                int index = startIndex;
                while (index < size) {
                    array[index] = true;
                    index += startIndex;
                }
            }
            startIndex++;
        }
    }
}
