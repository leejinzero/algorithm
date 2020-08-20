package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_2621_카드게임 {
	private static int[] num;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int[] mode = new int[4];
		int[] max = new int[4];
		num = new int[10];
		int maxNum = 0;

		for (int i = 0; i < 5; i++) {
			StringTokenizer tks = new StringTokenizer(bf.readLine());
			String card = tks.nextToken();
			int number = Integer.parseInt(tks.nextToken());
			if (number > maxNum)
				maxNum = number;	
			
			if (card.equals("R")) {
				mode[0]++;
				if (number > max[0])
					max[0] = number;
			}
			else if (card.equals("B")) {
				mode[1]++;
				if (number > max[1])
					max[1] = number;
			}
			else if (card.equals("Y")) {
				mode[2]++;
				if (number > max[2])
					max[2] = number;
			} 
			else {
				mode[3]++;
				if (number > max[3])
					max[3] = number;
			}
			num[number]++;
		}

		boolean isSame = false;
		for (int i = 0; i < 4; i++) {
			if (mode[i] == 5) {
				isSame = true;
			}
		}

		int sameNum = 0;
		int sameNumMax = 0;

		for (int i = 1; i < 10; i++) {
			if (sameNumMax == 3 && num[i] == 2) {
				System.out.println(sameNum * 10 + i + 700);
				return;
			}

			if (sameNumMax == 2 && num[i] == 3) {
				System.out.println(sameNum + i * 10 + 700);
				return;
			}

			if (sameNumMax == 2 && num[i] == 2) {
				System.out.println(Math.max(sameNum,i)*10+Math.min(sameNum, i)+300);
				return;
			}

			if (sameNumMax <num[i]) {
				sameNumMax = num[i];
				sameNum = i;
			}

		}

		boolean isSt = isStraight();

		if (isSame && isSt) {
			System.out.println(900 + maxNum);
		}

		else if (sameNumMax == 4) {
			System.out.println(800 + sameNum);
		}

		else if (isSame) {
			System.out.println(600 + maxNum);
		} 
		else if (isSt) {
			System.out.println(500 + maxNum);
		}

		else if (sameNumMax == 3) {
			System.out.println(400 + sameNum);
		} 
		else if (sameNumMax == 2) {
			System.out.println(200 + sameNum);

		}
		else System.out.println(100 + maxNum);

	}

	private static boolean isStraight() {
		boolean flag = false;
		int cnt =0;
		for (int i = 1; i < 10; i++) {
			if(cnt==5) return true;
			
			if (num[i] > 1)
				return false;
			
			if (flag && num[i] == 0) {
				return false;
			}
			
			if (num[i] == 1 && !flag) {
				flag = true;
			}
			
			if(num[i]==1) {
				cnt++;
			}
		}
		return true;

	}

}
