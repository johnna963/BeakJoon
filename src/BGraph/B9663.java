package BGraph;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class B9663 {
	static int N;
	static int[] map;
	static int cnt;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		map = new int[N];
		Backtracking(0);
		System.out.println(cnt);
	}
	static void Backtracking(int depth) {
		if(depth == N) {
			cnt++;
			return;
		}
		
		for (int i = 0; i < N; i++) {
			if(check(depth, i)) {
				map[depth] = i;
				Backtracking(depth+1);
			}
		}
	}
	static boolean check(int x,int y) {
		boolean flag = true;
		
		for (int i = 0; i < x ; i++) {
			int a = Math.abs(x-i);
			int b = Math.abs(y-map[i]);
			if(map[i] == y||a == b) {
				return false;
			}
		}
		return flag;
	}
}
