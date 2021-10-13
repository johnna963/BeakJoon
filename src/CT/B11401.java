package CT;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B11401 {
	static long M = 1000000007;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		long N = Integer.parseInt(st.nextToken());
		long K = Integer.parseInt(st.nextToken());
		
		long s = func(N);
		long m = func(K) * func(N-K) % M;
		///모듈러 연산에는 나눗셈이 없다. 
		//역원을 통해 분수를 곱셈꼴로 바꿔야한다.
		System.out.println(s * pow(m, M-2) % M);
		
		
	}
	static long func(long k) {
		long ans = 1;
		while(k > 1) {
			ans = (k * ans) % M;
			k--;
		}
		return ans;
	}
	
	//분할정복법
	static long pow(long base, long expo) {
		if(expo == 1) {
			return base % M;
		}
		long temp = pow(base, expo/2);
		if(expo % 2 == 1) {
			return(temp* temp % M) * base % M;
		}
		return temp * temp % M;
	}

}
