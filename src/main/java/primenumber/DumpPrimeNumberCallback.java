package primenumber;

public class DumpPrimeNumberCallback implements PrimeNumberCallback {
    final int amount;
    int index;

    public DumpPrimeNumberCallback(int amount) {
        this.amount = amount;
    }

    @Override
    public boolean consumeNextPrimeNumber(long primeNumber) {
        System.out.printf("consumeNextPrimeNumber[%d]: %d%n", ++index, primeNumber);
        return index != amount;
    }
}
