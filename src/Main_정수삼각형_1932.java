import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_정수삼각형_1932 {
	static int N;
	static Integer[][] dp;
	static int[][] map;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		dp = new Integer[N][N];
		for (int i = 0; i < N; i++) {
			String[] str = br.readLine().split(" ");
			for (int j = 0; j < str.length; j++) {
				map[i][j] = Integer.parseInt(str[j]);
			}
		}
		for (int i = 0; i < N; i++) {
			dp[N-1][i] = map[N-1][i];
		}
		System.out.println(maketri(0, 0));
	}
	static int maketri(int depth, int idx) {
		
		if(depth == N-1) {
			return dp[depth][idx];
		}
		if(dp[depth][idx] == null) {
			dp[depth][idx] = Math.max(maketri(depth+1, idx), maketri(depth+1, idx+1)) + map[depth][idx];
		}
		
		return dp[depth][idx];
		
	}
}
