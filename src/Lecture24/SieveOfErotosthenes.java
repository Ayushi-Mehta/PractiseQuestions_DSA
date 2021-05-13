package Lecture24;

import java.util.Arrays;

public class SieveOfErotosthenes {

	public static void main(String[] args) {
		// VERY FAMOUS ALGORITHM TO FIND PRIME NUMBERS TILL N
		SOE(25);
	}

	//
	public static void SOE(int n) {
		boolean[] primes = new boolean[n + 1];
		// so that index n is present in the array
		// default value of boolean[] is false
		Arrays.fill(primes, true);// VERY IMP

		primes[0] = false;
		primes[1] = false;

		for (int table = 1; table * table <= n; table++) {
			if (primes[table]) {
				for (int multi = 2; table * multi <= n; multi++) {

					primes[table * multi] = false;
				}
			}
		}
		for (int i = 0; i < primes.length; i++) {
			if (primes[i]) {
				System.out.print(i + " ");
			}
		}

	}
}
