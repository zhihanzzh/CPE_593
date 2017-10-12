import java.math.BigInteger;
import java.util.Scanner;

public class HW1a {
	public static int countPrimes(long m, long n) {
		if (m > n) {
			System.out.println("Invalid input! (b should be large than a)");
			return -1;
		}

		int count = 0;
		boolean[] isPrime = new boolean[(int) (n - m + 1)];
		boolean[] base = new boolean[(int) Math.sqrt(n) + 1];

		if (n < 2) {
			return 0;
		}

		for (int i = 4; i < base.length; i += 2) {
			base[(int) i] = true;
		}
		
		for (long i = m % 2 == 0 ? m : m + 1; i <= n; i += 2) {
			isPrime[(int) (i - m)] = true;
		}

		for (long i = 3; i < base.length; i += 2) {
			if (!base[(int) i]) {
				for (long j = i * i; j < base.length; j += 2 * i) {
					base[(int) j] = true;
				}

				if (m % i == 0) {
					if (m  % 2 == 0) {
						for (long j = m + i; j <= n; j += 2 * i) {
							isPrime[(int) (j - m)] = true;
						}
					} else {
						for (long j = m; j <= n; j += 2 * i) {
							isPrime[(int) (j - m)] = true;
						}
					}

				} else {
					long tmp = m + i - m % i;
					if (tmp % 2 == 0) {
						for (long j = tmp + i; j <= n; j += 2 * i) {
							isPrime[(int) (j - m)] = true;
						}
					} else {
						for (long j = tmp; j <= n; j += 2 * i) {
							isPrime[(int) (j - m)] = true;
						}
					}
				}
			}
		}

		for (int i = 0; i < isPrime.length; i++) {
			if (!isPrime[i]) {
				count++;
			}
		}
		
		if (m < 4) {
			count = count + 2;
		}

		return count;
	}

	public static void main(String[] args) {
		Scanner scr = new Scanner(System.in);
		System.out.println("Please input your first number (a):");
		long m = scr.nextLong();
		System.out.println("Please input your second number (b):");
		long n = scr.nextLong();
		System.out.println("There are " + countPrimes(m, n) + " prime numbers from " + m + " to " + n);
	}

}
