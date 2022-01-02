import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_한수_1065 {
	static int cnt = 0;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		for(int i = 1; i <= N; i++) {
			if(i >= 100) {
				check(i);
			}
			else if(i >= 10) {
				cnt++;
			}
			else {
				cnt++;
			}
		}
		System.out.println(cnt);
	}
	static void check(int num) {
		int[] arr = new int[3];
		arr[0] = num / 100;
		arr[1] = (num % 100) / 10;
		arr[2] = num % 10;
		int m1 = arr[1] - arr[0];
		int m2 = arr[2] - arr[1];
		if(m1 == m2) {
			cnt++;
		}
	}
}
