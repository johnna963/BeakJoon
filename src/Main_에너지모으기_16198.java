import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main_에너지모으기_16198 {
	static ArrayList<Integer> arr = new ArrayList<>();
	static int power = 0;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		for (int i = 0; i < N; i++) {
			arr.add(Integer.parseInt(st.nextToken()));
		}
		dfs(N,0);
		System.out.println(power);
	}
	static void dfs(int n, int sum) {
		if(n == 2) {
			power = Math.max(sum, power);
			return;
		}
		for (int i = 1; i < arr.size()-1; i++) {
			int num = arr.get(i-1) * arr.get(i+1);
			int temp = arr.get(i);
			arr.remove(i);
			dfs(n-1, sum+num);
			arr.add(i,temp);
		}
	}
}
