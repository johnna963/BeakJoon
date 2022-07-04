import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_금민수의개수_1527 {
	static int answer=0;
	static int min;
	static int max;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		min = Integer.parseInt(st.nextToken());
		max = Integer.parseInt(st.nextToken());
		solve(0);
		System.out.println(answer);
		
	}
	static void solve(long num) {
		if(num > max)
			return;
		
		if(num >= min && num<=max) {
			answer++;
		}
		solve(num * 10 + 4);
		solve(num * 10 + 7);
	}

}
