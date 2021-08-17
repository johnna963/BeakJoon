package BDP;

import java.util.Scanner;
public class B10844 {
	//쉬운 계단 수 점화식을 모르면 풀기가어렵다.
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		final long mod = 1000000000;
		long[][] arr = new long[N][10];
		
		for (int i = 1; i < 10; i++) {
			arr[0][i]=1;
		}
		for (int i = 1; i < N; i++) {
			arr[i][0] = arr[i-1][1];
			arr[i][9] = arr[i-1][8];
			for (int j = 1; j < 9; j++) {
				arr[i][j] = (arr[i-1][j-1]+arr[i-1][j+1])%mod;
			}
		}
//		for (int i = 0; i < 10; i++) {
//			for (int j = 0; j < 10; j++) {
//				System.out.print(arr[i][j] + " ");
//			}
//			System.out.println();
//		}
		
		long sum = 0;
		for (int i = 0; i < 10; i++) {
			sum += arr[N-1][i];
		}
		System.out.println(sum % mod);
	}
}
