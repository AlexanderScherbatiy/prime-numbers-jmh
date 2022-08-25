package sample;

import primenumber.DumpPrimeNumberCallback;
import primenumber.sieve.SieveOfEratosthenes;

public class PrimeNumberSample {
    public static void main(String[] args) {
        int amount = 10;
        System.out.printf("found first %d prime numbers:%n", amount);
        new SieveOfEratosthenes(30).findPrimeNumbers(new DumpPrimeNumberCallback(amount));
    }
}

