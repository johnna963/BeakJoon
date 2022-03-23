import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_거스름돈_5585 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = 1000 - Integer.parseInt(br.readLine());
		int[] coins = {500,100,50,10,5,1};
		int answer = 0;
		
		for (int i = 0; i < 6; i++) {
			if(coins[i] > N) {
				continue;
			}
			answer += N/coins[i];
			N %= coins[i];
		}
		System.out.println(answer);
	}
}
