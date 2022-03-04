import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main_특정한최단경로_1504 {
	static int N;
	static int E;
	static int[] distance;
	static int INF = Integer.MAX_VALUE;
	static ArrayList<Node>[] arr;
	
	static class Node implements Comparable<Node>{
		int end;
		int weight;
		public Node(int end, int weight) {
			this.end = end;
			this.weight = weight;
		}
		@Override
		public int compareTo(Node o) {
			return weight-o.weight;
		}
	}
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());
		arr = new ArrayList[N+1];
		for (int i = 1; i <= N; i++) {
			arr[i] = new ArrayList<>();
		}
		
		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int wei = Integer.parseInt(st.nextToken());
			arr[from].add(new Node(to,wei));
			arr[to].add(new Node(from,wei));
		}
		st = new StringTokenizer(br.readLine());
		int v1 = Integer.parseInt(st.nextToken());
		int v2 = Integer.parseInt(st.nextToken());
		
		long dist1 = 0;
		dist1 += dijkstra(1,v1);
		dist1 += dijkstra(v1,v2);
		dist1 += dijkstra(v2,N);
		long dist2 = 0;
		dist2 += dijkstra(1,v2);
		dist2 += dijkstra(v2,v1);
		dist2 += dijkstra(v1,N);
		if(Math.min(dist1, dist2) >=INF) {
			System.out.println(-1);
			return;
		}
		System.out.println(Math.min(dist1, dist2));
		
	}
	 static long dijkstra(int start, int end) {
		 distance = new int[N+1];
		 Arrays.fill(distance, INF);
		 distance[start] = 0;
		 PriorityQueue<Node> pq = new PriorityQueue<>();
		 pq.add(new Node(start,0));
		 while(!pq.isEmpty()) {
			 Node node = pq.poll();
			 int vertex = node.end;
			 int weight = node.weight;
			 if(distance[vertex] < weight) {
				 continue;
			 }
			 for(int i = 0; i<arr[vertex].size(); i++) {
				 int n_vertex = arr[vertex].get(i).end;
				 int n_weight = arr[vertex].get(i).weight+weight;
				 if(distance[n_vertex] > n_weight) {
					 distance[n_vertex] = n_weight;
					 pq.add(new Node(n_vertex,n_weight));
				 }
			 }
		 }
		 return distance[end];
	}
}
