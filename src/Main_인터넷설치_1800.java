import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main_인터넷설치_1800 {
	static int N;
	static int P;
	static int K;
	static ArrayList<Node>[] map;
	static int[] dist;
	static class Node implements Comparable<Node> {
		private int index;
		private int value;
		
		public Node(int index, int value) {
			this.index = index;
			this.value = value;
		}
		public int compareTo(Node o) {
			return this.value - o.value;
		}
	}
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		P = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		map = new ArrayList[N+1];
		dist = new int[N+1];
		
		for(int i = 1; i<=N;i++) {
			map[i] = new ArrayList<>();
		}
		int end = 0;
		for(int i = 0; i < P; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int value = Integer.parseInt(st.nextToken());
			
			map[from].add(new Node(to, value));
			map[to].add(new Node(from, value));
			
			end = Math.max(end, value);
		}
		
		int start = 0;
		int answer = Integer.MIN_VALUE;
		
		while(start<=end) {
			int mid = (start + end) / 2;
			
			if(dijstra(mid)) {
				answer = mid;
				end = mid - 1;
			}
			else {
				start = mid +1;
			}
		}
		
		if(answer == Integer.MIN_VALUE) {
			System.out.println(-1);
			return;
		}
		System.out.println(answer);
	}
	static boolean dijstra(int x) {
		PriorityQueue<Node> pQueue = new PriorityQueue<>();
		
		for(int i = 1; i<=N;i++) {
			dist[i] = Integer.MAX_VALUE;
		}
		dist[1] = 0;
		pQueue.add(new Node(1,0));
		
		while(!pQueue.isEmpty()) {
			Node node = pQueue.poll();
			
			int now = node.index;
			int cost = node.value;
			
			if(dist[now] < cost) {
				continue;
			}
			for(Node n: map[now]) {
				int next = n.index;
				int nextCost = cost;
				
				if(n.value > x) {
					nextCost +=1;
				}
				
				if(nextCost < dist[next]) {
					dist[next] = nextCost;
					pQueue.add(new Node(next, nextCost));
				}
			}
		}
		return dist[N] <= K;
	}
}
