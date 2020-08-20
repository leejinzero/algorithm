package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BJ_2309_일곱난쟁이 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

		int[] smaller = new int[9];

		int total = 0;
		for (int i = 0; i < 9; i++) {
			smaller[i] = Integer.parseInt(bf.readLine());
			total += smaller[i];
		}
		
		Arrays.sort(smaller);

		int diff = total - 100;

	here: for (int i = 0; i < 9; i++) {
			for (int j = i + 1; j < 9; j++) {
				int sum = smaller[i]+ smaller[j];
				if (sum == diff) {
					
					for (int j2 = 0; j2 < 9; j2++) {
						if(j2!=i && j2!=j) {
							System.out.println(smaller[j2]);
						}
					}
					
					
					break here;
				}
			}
		}

	}

}
