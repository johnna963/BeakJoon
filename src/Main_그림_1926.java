import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_그림_1926 {
	static boolean[][] visited;
	static int[][] picture;
	static int cnt;
	static int size;
	static int n;
	static int m;
	static class Node{
		int x;
		int y;
		public Node(int x, int y) {
			this.x=x;
			this.y=y;
		}
	}
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		picture = new int[n][m];
		visited = new boolean[n][m];
		for(int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < m; j++) {
				picture[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if(picture[i][j] == 1 && !visited[i][j]) {
					bfs(i,j);
				}
			}
		}
		System.out.println(cnt);
		System.out.println(size);
	}
	static void bfs(int x, int y) {
		Queue<Node> queue = new LinkedList<Node>();
		queue.add(new Node(x,y));
		visited[x][y] = true;
		int max = 1;
		int[] dx = {-1,0,1,0};
		int[] dy = {0,-1,0,1};
		while(!queue.isEmpty()) {
			Node node = queue.poll();
			for (int k = 0; k < 4; k++) {
				int nx = node.x + dx[k];
				int ny = node.y + dy[k];
				if(nx>=0 && ny>=0 && nx<n && ny<m) {
					if(!visited[nx][ny] && picture[nx][ny]==1) {
						queue.add(new Node(nx, ny));
						visited[nx][ny] = true;
						max++;
					}
				}
			}
		}
		cnt++;
		size = Math.max(max, size);
	}
}
