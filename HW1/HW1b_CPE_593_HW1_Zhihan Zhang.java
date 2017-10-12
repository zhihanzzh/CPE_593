package cpe593;
/*
 * 
 * Course: CPE - 593
 * Homework: 1
 * Student Name: Zhihan Zhang
 * Student ID: 10420346
 * 
 * 09/12/2017
 */

public class HW1 {
	private static long[][] storage = new long[100][100];
	
	private static long calculateCombinations(int n, int r) {
		if (storage[n][r] != 0) {
			return storage[n][r]; 
		} else {
			if (n == 0 || r == 0 || r == n || n == 1) {
				return storage[n][r] = 1;
			}
			
			if(r == 1) {
				return storage[n][r] = n;
			}
			 
			return storage[n][r] = calculateCombinations(n - 1, r - 1) + calculateCombinations(n - 1, r);
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(calculateCombinations(52 , 1));
		double sum = 0;
		for(int i = 0; i < 100000000; i++) {
			sum += calculateCombinations(52,26);
		}
		
		System.out.println(sum);
	}

}
