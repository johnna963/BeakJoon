import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_¹ÂÅ»¸®½ºÅ©_12869 {
	static int min;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		
		int[][] deal = {
				{9,3,1},
				{9,1,3},
				{3,9,1},
				{3,1,9},
				{1,9,3},
				{1,3,9}
		};
		
		int[] SCV = new int[3];
		for (int i = 0; i < N; i++) {
			SCV[i] = Integer.parseInt(st.nextToken());
		}
		int[][][] dp = new int[61][61][61];
		min = Integer.MAX_VALUE;
		DFS(SCV, dp, deal, 0);
		System.out.println(min);
	}
	public static void DFS(int[] scv, int[][][] dp, int[][] deal, int cnt) {
		int scv1 = scv[0];
		int scv2 = scv[1];
		int scv3 = scv[2];
		
		if(min <= cnt)
			return;
		
		if(dp[scv1][scv2][scv3] != 0 && dp[scv1][scv2][scv3] <= cnt)
			return;
		dp[scv1][scv2][scv3] = cnt;
		
		if(scv1 == 0 && scv2 == 0 && scv3 == 0) {
			min = Math.min(min, cnt);
			return;
		}
		
		for (int i = 0; i < 6; i++) {
			DFS(new int[] {Math.max(scv1 - deal[i][0], 0), Math.max(scv2 - deal[i][1], 0), Math.max(scv3 - deal[i][2], 0)}, dp, deal, cnt+1);
		}
		
	}
}
