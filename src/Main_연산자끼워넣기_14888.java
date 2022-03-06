import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_연산자끼워넣기_14888 {
	static int[] number;
	static int N;
	static int[] operator;
	static int Max = Integer.MIN_VALUE;
	static int Min = Integer.MAX_VALUE;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		number = new int[N];
		operator = new int[4];
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < N; i++) {
			number[i] = Integer.parseInt(st.nextToken());
		}
		st = new StringTokenizer(br.readLine()," ");
		for (int i = 0; i < 4; i++) {
			operator[i] = Integer.parseInt(st.nextToken());
		}
		dfs(number[0], 1);
		System.out.println(Max);
		System.out.println(Min);
	}
	static void dfs(int num, int idx) {
		if(idx == N) {
			Max = Math.max(Max, num);
			Min = Math.min(Min, num);
			return;
		}
		for (int i = 0; i < 4; i++) {
			if(operator[i]>0) {
				operator[i]--;
				switch (i) {
				case 0:
					dfs(num + number[idx], idx + 1);
					break;
				case 1:
					dfs(num - number[idx], idx + 1);
					break;
				case 2:
					dfs(num * number[idx], idx + 1);
					break;
				case 3:
					dfs(num / number[idx], idx + 1);
					break;
				}
				operator[i]++;
			}
		}
	}
}
