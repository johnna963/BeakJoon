import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_암호코드_2011 {
	/**
	 * 25 -> 2 5 , 25
	 * 251 -> 2 5 1, 25 1
	 * 2511 -> 2 5 1 1, 25 1 1, 25 11, 2 5 11
	 * 25114 */
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String str = br.readLine();
		
		int mod = 1000000;
		int[] dp = new int[str.length() + 1];
		
		dp[0] = 1;
		
		for (int i = 1; i <= str.length(); i++) {
			int letter = str.charAt(i-1) - '0';
			if(letter >=1 && letter <= 9 ) {
				dp[i] += dp[i-1];
				dp[i] %= mod;
			}
			if(i==1)continue;
			int letter2 = str.charAt(i - 2) - '0';
			
			int ten = letter2 * 10 + letter;
			
			if(ten >= 10 && ten <= 26) {
				dp[i] += dp[i-2];
				dp[i] %= mod;
			}
		}
		System.out.println(dp[str.length()]);
	}
}
