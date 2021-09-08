package BGraph;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class B1753 {
	static int V;
	static int E;
	static int[] dist;
	static boolean[] visit;
	static ArrayList<Node>[] arr;
	static class Node implements Comparable<Node>{
		int to;
		int cost;
		
		public Node(int to, int cost) {
			super();
			this.to = to;
			this.cost = cost;
		}

		@Override
		public int compareTo(Node o) {
			return Integer.compare(this.cost ,o.cost);
		}
	}
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		st = new StringTokenizer(br.readLine()," ");
		
		V = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());
		arr = new ArrayList[V+1];
		visit = new boolean[V+1];
		
		for (int i = 0; i < arr.length; i++) {
			arr[i] = new ArrayList<Node>();
		}
		
		int start = Integer.parseInt(br.readLine());
		
		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine()," ");
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int cost = Integer.parseInt(st.nextToken());
			arr[from].add(new Node(to,cost));
		}
		find_min(start);
		for (int i = 1; i < dist.length; i++) {
			if(dist[i]==-1) {
				sb.append("INF").append("\n");
			}
			else
			sb.append(dist[i]).append("\n");
		}
		System.out.println(sb);
	}
	static void find_min(int start) {
		dist = new int[V+1];
	
		Arrays.fill(dist, -1);
		dist[start] = 0;
		PriorityQueue<Node> pq = new PriorityQueue<Node>();
		pq.add(new Node(start,0));
		
		while(!pq.isEmpty()) {
			Node current = pq.poll();
			if(!visit[current.to]) {
				visit[current.to] = true;
			}
			for (Node node : arr[current.to]) {
				if(dist[node.to]==-1||dist[node.to]>dist[current.to]+node.cost) {
					dist[node.to] = dist[current.to] + node.cost;
					pq.add(new Node(node.to,dist[node.to]));
				}
			}
		}
	}
}
