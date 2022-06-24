import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_알고리즘수업BFS1 {
	static ArrayList<Integer>[] arr;
	static boolean[] visited;
	static int[] answer;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int R = Integer.parseInt(st.nextToken());
		
		arr = new ArrayList[N+1];
		visited = new boolean[N+1];
		answer = new int[N+1];
		for (int i = 0; i < N+1; i++) {
			arr[i] = new ArrayList<>();
			Collections.sort(arr[i]);
		}
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine()," ");
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			
			arr[u].add(v);
			arr[v].add(u);
		}
		for (int i = 0; i < N+1; i++) {
			Collections.sort(arr[i]);
		}
		bfs(R);
		for (int i = 1; i < N+1; i++) {
			System.out.println(answer[i]);
		}
		
	}
	static void bfs(int start) {
		Queue<Integer> queue = new LinkedList<>();
		queue.add(start);
		visited[start] = true;
		int cnt = 1;
		while(!queue.isEmpty()) {
			int cur = queue.poll();
			answer[cur] = cnt;
			cnt++;
			for (int i = 0; i < arr[cur].size(); i++) {
				int next = arr[cur].get(i);
				if(!visited[next]) {
					queue.add(next);
					visited[next] = true;
				}
			}
		}
	}
}
