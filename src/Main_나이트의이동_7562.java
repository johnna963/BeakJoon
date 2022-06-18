import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_나이트의이동_7562 {
	static class Node{
		int x;
		int y;
		public Node(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		for (int testCase = 0; testCase < T; testCase++) {
			int N = Integer.parseInt(br.readLine());
			int[][] map = new int[N][N];
			boolean[][] visit = new boolean[N][N];
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			st = new StringTokenizer(br.readLine()," ");
			int ox = Integer.parseInt(st.nextToken());
			int oy = Integer.parseInt(st.nextToken());
			bfs(x,y,map,visit,N);
			System.out.println(map[ox][oy]);
		}
		
	}
	static void bfs(int x, int y, int[][] map, boolean[][] visit, int N) {
		Queue<Node> queue = new LinkedList<>();
		queue.add(new Node(x,y));
		visit[x][y] = true;
		int[][] dxy = {
				{-2, 1}, {-1, 2}, {2, 1}, {1, 2},
				{2, -1}, {1, -2}, {-2, -1}, {-1,-2}
				};
		while(!queue.isEmpty()) {
			Node node = queue.poll();
			int cx = node.x;
			int cy = node.y;
			for (int i = 0; i < 8; i++) {
				int nx = cx + dxy[i][0];
				int ny = cy + dxy[i][1];
				
				if(nx >=0 && nx < N && ny >= 0 && ny < N && !visit[nx][ny]) {
					queue.add(new Node(nx, ny));
					visit[nx][ny] = true;
					map[nx][ny] = map[cx][cy] + 1;
				}
			}
		}
	}

}
