package BPandC;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class B10974 {
	static int N;
	static int[] arr;
	static boolean[] visited;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		arr = new int[N];
		int[] output = new int[N];
		visited = new boolean[N];
	
		//Arrays.fill(visited, false);
		perm(output,0);
	}
	static void perm(int[] output, int depth) {
		StringBuilder sb = new StringBuilder();
		if(depth==N) {
			for (int i = 0; i < output.length; i++) {
				System.out.print(output[i]+" ");
			}
			System.out.println();
			return;
		}
		for (int i = 0; i < N ; i++) {
			if(!visited[i]) {
				visited[i] = true;
				output[depth] = i + 1;
				perm(output,depth+1);
				visited[i] = false;
			}
		}
	}
}
