package CT;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B11050 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int answer = func(N)/(func(K)* func(N-K));
		System.out.println(answer);
		
	}
	static int func(int k) {
		int ans = 1;
		for (int i = 1; i <= k; i++) {
			ans *= i;
		}
		return ans;
	}
}
