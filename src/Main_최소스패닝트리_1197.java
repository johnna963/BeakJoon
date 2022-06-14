import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main_최소스패닝트리_1197 {
	static class Node implements Comparable<Node>{
		int from;
		int to;
		int cost;
		
		public Node(int from, int to, int cost) {
			this.from = from;
			this.to = to;
			this.cost = cost;
		}
		public int compareTo(Node o) {
			return cost - o.cost;
		}
	}
	static int[] parent;
	static PriorityQueue<Node> pq = new PriorityQueue<>();
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		int answer = 0;
		int V = Integer.parseInt(st.nextToken());
		int E = Integer.parseInt(st.nextToken());
		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int cost = Integer.parseInt(st.nextToken());
			pq.add(new Node(from,to,cost));
		}
		
		parent = new int[V+1];
		
		for (int i = 1; i <= V; i++) {
			parent[i] = i;
		}
		
		while(!pq.isEmpty()) {
			Node node = pq.poll();
			int to = find(node.to);
			int from = find(node.from);
			
			if(!union(to,from)) {
				answer += node.cost;
			}
		}
		System.out.println(answer);
	}
	static int find(int a) {
		if(a==parent[a]) return a;
		return parent[a] = find(parent[a]);
	}
	static boolean union(int a, int b) {
		int aRoot = find(a);
		int bRoot = find(b);
		if(aRoot == bRoot) {
			return true;
		}
		parent[bRoot] = aRoot;
		return false;
	}
}
