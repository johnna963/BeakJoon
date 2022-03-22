import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_동전1_2293 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		
		int[] token = new int[n];
		int[] dp = new int[k+1];
		for (int i = 0; i < n; i++) {
			token[i] = Integer.parseInt(br.readLine());
		}
		
		dp[0] = 1;
		
		for (int i = 0; i < n; i++) {
			for (int j = 1; j <= k; j++) {
				if(j>= token[i]) {
					dp[j] = dp[j]+dp[j-token[i]];
				}
			}
		}
		System.out.println(dp[k]);
	}
}
