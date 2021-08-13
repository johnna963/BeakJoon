package BDP;

import java.util.Scanner;

public class B2579 {
	//포도주 시식과 비슷함 그러나 마지막 계단을 반드시 밟아야함
	static int[] arr;
	static Object[] dp;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		arr = new int[N+1];
		dp = new Object[N+1];
		for (int i = 1; i < N+1; i++) {
			arr[i] = sc.nextInt();
		}
		dp[0] = 0;
		dp[1] = arr[1];
		if(N>1) {
			dp[2] = arr[1]+arr[2];
		}
		System.out.println(recur(N));
	}
	
	public static int recur(int N) {
		
		if(dp[N]==null) {
			dp[N] = Math.max(recur(N-2),recur(N-3)+arr[N-1])+arr[N];
		}
		return (int) dp[N];
	}
}
