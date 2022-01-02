import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_분해합_2231 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int num = 0;
		int res = 0;
		for(int i = 1; i < N ;i++) {
			num = calc(i);
			if(num == N) {
				res = i;
				break;
			}
		}
		System.out.println(res);
	}
	static int calc(int num) {
		int sum = num;
		while(num != 0) {
			sum += num % 10;
			num /= 10;
		}
		return sum;
	}
}
