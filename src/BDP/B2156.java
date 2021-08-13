package BDP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B2156 {

	static int[] arr;
	static Object[] dp;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int answer = 0;
		
		int N = Integer.parseInt(br.readLine());
		arr = new int[N+1];//잔
		dp = new Object[N+1];//마지막 잔을 마셨을때
		for (int i = 1; i < N+1; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		 dp[0]=0;
		 dp[1]=arr[1];
		 
		 if(N>1) {
			 dp[2] = arr[1]+arr[2];
		 }
		 System.out.println(Recursive(N));

	}
	public static int Recursive(int N)
	{
		if(dp[N]==null) {
		dp[N] = Math.max(Math.max(Recursive(N-2), Recursive(N-3)+arr[N-1])+arr[N], Recursive(N-1));
		}
		return (int) dp[N];
	}

}
