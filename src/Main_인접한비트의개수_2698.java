import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_인접한비트의개수_2698 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for (int testCase = 0; testCase < T; testCase++) {
			StringTokenizer st = new StringTokenizer(br.readLine()," ");
			int n = Integer.parseInt(st.nextToken());
			int k = Integer.parseInt(st.nextToken());
			
			int[][][] dp = new int[2][101][101];
			dp[0][1][0] = 1;
			dp[1][1][0] = 1;
			
			for (int i = 2; i < n+1; i++) {
				for (int j = 0; j < k+1; j++) {
					dp[0][i][j] = dp[0][i-1][j] + dp[1][i-1][j];
					
					if(j==0) {
						dp[1][i][j] = dp[0][i-1][j];
					}
					else {
						dp[1][i][j] = dp[0][i-1][j] + dp[1][i-1][j-1];
					}
				}
			}
			int answer = dp[0][n][k] + dp[1][n][k];
			System.out.println(answer);
		}
	}
}
