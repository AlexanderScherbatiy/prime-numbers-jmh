package primenumber.sieve;

import primenumber.PrimeNumberCallback;

import java.util.List;
import java.util.ArrayList;

public class InfinitySieveOfEratosthenes {

    private final int sieveSize;
    private final boolean[] mark;

    private final List<PrimeItem> primes = new ArrayList<>();

    public InfinitySieveOfEratosthenes(int sieveSize) {
        this.sieveSize = sieveSize;
        this.mark = new boolean[sieveSize];
    }

    public void findPrimeNumbers(PrimeNumberCallback callback) {


        // 2 is the first prime number
        mark[0] = true;
        mark[1] = true;

        int sieveIndex = 0;
        long base = 0;
        long limit = sieveSize;

        int itemSize = 0;
        int itemIndex = 0;

        while (true) {

            // check new prime number
            while (sieveIndex < sieveSize) {
                if (!mark[sieveIndex]) {
                    long prime = base + sieveIndex;
                    if (!callback.consumeNextPrimeNumber(prime)) {
                        return;
                    }
                    primes.add(new PrimeItem(prime));
                    itemSize++;
                    sieveIndex++;
                    break;
                }

                mark[sieveIndex] = false;
                sieveIndex++;
            }

            if (sieveIndex >= sieveSize) {
                itemIndex = 0;
                sieveIndex = 0;
                base = limit;
                limit += sieveSize;
            }

            // check there is no new added prime numbers
            if (itemIndex >= itemSize) {
                itemIndex = 0;
            }

            // mark the sieve using the known prime numbers
            while (itemIndex < itemSize) {
                PrimeItem item = primes.get(itemIndex);
                long prime = item.prime;
                long index = item.index;
                while (index < limit) {
                    mark[(int) (index - base)] = true;
                    index += prime;
                }
                item.index = index;
                itemIndex++;
            }
        }
    }

    private static class PrimeItem {
        private final long prime;
        private long index;

        public PrimeItem(long prime) {
            this.prime = prime;
            this.index = prime + prime;
        }
    }
}
