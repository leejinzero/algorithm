package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ_2816_디지털티비 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(bf.readLine());

		String[] channels = new String[N];
		int kbs1 = 0, kbs2 = 0;

		String order = "";
		for (int i = 0; i < N; i++) {
			channels[i] = bf.readLine();
			if (channels[i].equals("KBS1"))
				kbs1 = i;
			else if (channels[i].equals("KBS2"))
				kbs2 = i;
		}

		for (int i = 0; i < kbs1; i++) {
			order += "3";
		}
		kbs1 -= 1;
		if (kbs1 > 0) {
			order += "2";
		}
		for (int i = 0; i < kbs1; i++) {
			order += "4";
		}
		if (kbs1 != 0) {
			order += "1";
		}
		for (int i = 0; i < kbs2 - 1; i++) {
			order += "3";
		}

		kbs2 -= 1;
		if (kbs2 > 1) {
			order += "2";
		}
		for (int i = 0; i < kbs2 - 1; i++) {
			order += "4";
		}

		System.out.println(order);

	}

}
