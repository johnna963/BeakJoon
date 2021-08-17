package BGraph;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class B1260 {
	static int N;
	static int M;
	static int V;
	static LinkedList<Integer>[] tree;
	static boolean[] visited;
	@SuppressWarnings("unchecked")
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		StringBuilder sb = new StringBuilder();
		StringBuilder Sb = new StringBuilder();
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		V = Integer.parseInt(st.nextToken());
		tree = new LinkedList[N+1];
		visited = new boolean[N+1];
		for(int i = 1; i < N + 1; i++) {
            tree[i] = new LinkedList<Integer>();
        }
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine()," ");
			
			int p = Integer.parseInt(st.nextToken());
			int s = Integer.parseInt(st.nextToken());
			
			tree[s].add(p);
			tree[p].add(s);
		}
		for (int i = 1; i < N+1; i++) {
			Collections.sort(tree[i]);
			//arrays.list는 오류
			//안하면 케이스에서 어긋남
		}
		
		Arrays.fill(visited, false);
		DFS(V,sb);
		System.out.println(sb);
		
		Arrays.fill(visited, false);
		BFS(V,Sb);
		System.out.println(Sb);
		}
	
	static void DFS(int v, StringBuilder sb) {
		if(visited[v]) {
			return;
		}
		visited[v] = true;
		sb.append(v).append(" ");
		for (int k : tree[v]) {
			if(!visited[k])
				DFS(k,sb);
		}
	}
	
	static void BFS(int v, StringBuilder Sb) {
		 Queue<Integer> q = new LinkedList<Integer>();
		 q.add(v);
		 visited[v] = true;
		 while(!q.isEmpty()) {
			 int w = q.poll();
			 Sb.append(w).append(" ");
			 for (int k : tree[w]) {
				 if(!visited[k]) {
					 q.add(k);
					 visited[k]=true;
				 }
			}
			 
		 }
		 
	}
}
