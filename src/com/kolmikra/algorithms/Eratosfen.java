package com.kolmikra.algorithms;

import java.util.*;

public class Eratosfen {
    private int n;
    private Set<Integer> sieve = new HashSet<>();
    private BitSet bitSieve = new BitSet();

    public Eratosfen(int n) {
        this.n = n;
        for (int i = 2; i <= n; i++) {
            sieve.add(i);

        }
        bitSieve.set(2, n + 1);
    }

    public Set<Integer> getSieve() {
        return sieve;
    }

    public BitSet getBitSieve() {
        return bitSieve;
    }

    public Set<Integer> getHashSetPrime() {
        Set<Integer> prime = new LinkedHashSet<>();
        int min = Collections.min(sieve);
        while (Math.pow(min, 2) <= n) {
            for (int i = 0; i <= n; i++) {
                sieve.remove(min * min);
                sieve.remove(min * (min + i));
                sieve.remove(min * (min + i + 1));
            }
            prime.add(min);
            sieve.remove(min);
            min = Collections.min(sieve);
        }
        prime.addAll(sieve);
        return prime;
    }

    public Set<Integer> getBitSetPrime() {
        Set<Integer> prime = new LinkedHashSet<>();
        int min = bitSieve.nextSetBit(0);
        while (Math.pow(min, 2) <= n) {
            for (int i = 0; i <= n; i++) {
                bitSieve.clear(min * min);
                bitSieve.clear(min * (min + i));
                bitSieve.clear(min * (min + i + 1));
            }
            prime.add(min);
            bitSieve.clear(min);
            min = bitSieve.nextSetBit(0);
        }
        int count = bitSieve.cardinality();
        for (int i = 0; i < count; i++) {
            prime.add(bitSieve.nextSetBit(i));
            bitSieve.clear(bitSieve.nextSetBit(i));
        }
        return prime;
    }

}
