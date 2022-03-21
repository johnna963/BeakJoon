import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_타일채우기_2133 {
	/**
	 * n이 홀수일경우 불가능
	 * n = 2 a = 3
	 * 
	 * n = 4 a = 11 
	 * 
	 * */
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int answer = 0;
		int N = Integer.parseInt(br.readLine());
		int[] dp = new int[N+1];
		
		if(N%2 == 1) {
			answer = 0;
		}
		else {
			dp[0] = 1;
			dp[2] = 3;
			for (int i = 4; i <= N; i+=2) {
				dp[i] = dp[i-2] * dp[2];
				for (int j = i-4; j >= 0; j -=2) {
					dp[i] += dp[j] * 2;
				}
			}
			answer = dp[N];
		}
		
		System.out.println(answer);
	}

}
