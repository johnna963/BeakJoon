import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_다리놓기_1010 {
	static int[][] dp = new int[30][30];
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for (int testCase = 0; testCase < T; testCase++) {
			StringTokenizer st = new StringTokenizer(br.readLine()," ");
			
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			
			System.out.println(comb(M, N));
		}
	}
	static int comb(int m, int n) {
		if(dp[m][n] > 0) {
			return dp[m][n];
		}
		if(m == n || n == 0 ) {
			return dp[m][n] = 1;
		}
		return dp[m][n] = comb(m-1, n-1) + comb(m - 1, n);
	}
}
