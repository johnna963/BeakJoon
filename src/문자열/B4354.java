package 문자열;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class B4354 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		while(true) {
			String str = br.readLine();
			if(str.equals(".")) {
				break;
			}
			int max = 0;
			int[] pi = new int[str.length()];
			for (int i = 1,j=0; i < str.length(); i++) {
				while(j>0 && str.charAt(i)!=str.charAt(j)) {
					j = pi[j-1];
				}
				if(str.charAt(i) == str.charAt(j)) {
					pi[i]=++j;
					max = Math.max(max, pi[i]);
					//반복문자열 패턴포인터?
				}
				System.out.println(pi[i]);
			}
			
			int num = str.length() % (str.length() - pi[str.length() - 1]);
			//반복문자열이 몇개 들어있니?
			if(num!=0) {
				sb.append(1).append("\n");
			}
			else {
				int n = str.length() / (str.length() - pi[str.length() - 1]);
				sb.append(n).append("\n");
			}
		}
		//System.out.println(sb);
	}
}
