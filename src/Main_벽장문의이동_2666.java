import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main_벽장문의이동_2666 {
	static ArrayList<Integer> open;
	static int[] target;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		String[] closet = br.readLine().split(" ");
		open = new ArrayList<>();
		
		for (int i = 0; i < closet.length; i++) {
			open.add(Integer.parseInt(closet[i]));
		}
		
		int size = Integer.parseInt(br.readLine());
		target = new int[size];
		
		for (int i = 0; i < size; i++) {
			target[i] = Integer.parseInt(br.readLine());
		}
		System.out.println(solve(0, open.get(0), open.get(1)));
	}
	static int solve(int cnt, int a, int b) {
		if(cnt == target.length) return 0;
		
		int temp1 = Math.abs(a - target[cnt]);
		int temp2 = Math.abs(b - target[cnt]);
		
		return Math.min(temp1 + solve(cnt + 1,target[cnt], b), temp2 + solve(cnt + 1, a, target[cnt]));
	}
}
