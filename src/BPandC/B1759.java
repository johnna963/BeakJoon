package BPandC;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B1759 {
	/**조합 문제
	 * start depth?*/
	static int L;
	static int C;
	static String[] str;
	static boolean[] visited;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		
		L = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		str = new String[C];
		visited = new boolean[C];
		
		st = new StringTokenizer(br.readLine()," ");
		for (int i = 0; i < C; i++) {
			str[i] = st.nextToken();
		}
		Arrays.sort(str);//사전순으로 하기 위한 빌드업
		solve(0,0);
		
	}
	static void solve(int start, int depth) {
		if(depth == L) {
			int Vowel = 0;//모음세기
			int consonant = 0;//자음세기
			StringBuilder sb = new StringBuilder();
			for (int i = 0; i < C; i++) {
				if(visited[i]) {
					sb.append(str[i]);
					
					if(str[i].equals("a")||str[i].equals("e")||str[i].equals("i")||
							str[i].equals("o")||str[i].equals("u")) {
						//문자열 비교를 잊지말자
						Vowel++;
					}
					else {
						consonant++;
					}
				}
			}
			if(Vowel>=1 && consonant>=2) {
				System.out.println(sb);
			}
		}
		for (int i = start; i < C; i++) {
			visited[i] = true;
			solve(i+1, depth+1);//반드시 i+1...
			visited[i] = false;
		}
	}
}
