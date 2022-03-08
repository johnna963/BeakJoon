import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_숫자야구_2503 {
	static int N;
	static String[] num;
	static int[] strike;
	static int[] ball;
	static boolean[] visit;
	static int answer;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		StringTokenizer st;
		num = new String[N];
		strike = new int[N];
		ball = new int[N];
		visit = new boolean[9];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine()," ");
			num[i] = st.nextToken();
			strike[i] = Integer.parseInt(st.nextToken());
			ball[i] = Integer.parseInt(st.nextToken());
		}
		int[] arr = {1,2,3,4,5,6,7,8,9};
		int[] output = new int[3];
		perm(0, visit, arr, output);
		System.out.println(answer);
	}
	static void perm(int depth, boolean[] visited, int[] arr, int[] output) {
		if(depth == 3) {
			String baseball = "";
			for (int i = 0; i < output.length; i++) {
				baseball+=Integer.toString(output[i]);
			}
			if(checkbaseball(baseball)) {
				answer++;
			}
			return;
		}
		for (int i = 0; i < 9; i++) {
			if(!visited[i]) {
				visited[i] = true;
				output[depth] = arr[i];
				perm(depth+1, visited, arr, output);
				visited[i]=false;
			}
		}
	}
	static boolean checkbaseball(String baseball) {
		String[] num1 = baseball.split("");
		for (int i = 0; i < N; i++) {
			String[] num2 = num[i].split("");
			int cnt_strike = 0;
			int cnt_ball = 0;
			
			for (int j = 0; j < 3; j++) {
				if(num1[j].equals(num2[j])) {
					cnt_strike++;
				}
			}
			for (int j = 0; j < 3; j++) {
				for (int k = 0; k < 3; k++) {
					if(j==k) continue;
					else {
						if(num1[j].equals(num2[k])) {
							cnt_ball++;
						}
					}
				}
			}
			if(strike[i] !=cnt_strike || ball[i] != cnt_ball) {
				return false;
			}
		}
		return true;
	}
}
