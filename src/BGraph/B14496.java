package BGraph;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class B14496 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		int a = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine()," ");
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		ArrayList<Integer>[] arr = new ArrayList[n+1];
		
		for (int i = 0; i < arr.length; i++) {
			arr[i] = new ArrayList<Integer>();
		}
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine()," ");
			int c1 = Integer.parseInt(st.nextToken());
			int c2 = Integer.parseInt(st.nextToken());
			arr[c1].add(c2);
			arr[c2].add(c1);
		}
		Queue<Integer> q = new LinkedList<Integer>();
		q.add(a);
		int[] dist = new int[n+1];
		Arrays.fill(dist, Integer.MAX_VALUE);
		dist[a] = 0;
		while(!q.isEmpty()) {
			int now = q.poll();
			for (int i = 0; i < arr[now].size(); i++) {
				int next = arr[now].get(i);
				if(dist[next]>dist[now]+1) {
					dist[next] = dist[now]+1;
					q.add(next);
				}
			}
		}
		if(dist[b] == Integer.MAX_VALUE) {
			System.out.println(-1);
		}
		else
		{
			System.out.println(dist[b]);
		}
	}

}
