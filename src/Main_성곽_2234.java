import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_성곽_2234 {
	static int answer1 = 0;
	static int answer2 = 0;
	static int answer3 = 0;
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
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		boolean[][] visited = new boolean[M][N];
		int[][][] wallarr = new int[M][N][2];
		int[][] arr = new int[M][N];
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine()," ");
			for (int j = 0; j < N; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		for (int i = 0; i < M; i++) {
			for (int j = 0; j < N; j++) {
				if(!visited[i][j]) {
					bfs(i,j,answer1,visited,arr,N,M, wallarr);
					answer1++;
				}
			}
		}
		MaxRoom(M, N, wallarr);
		
		System.out.println(answer1);
		System.out.println(answer2);
		System.out.println(answer3);
	}
	static void bfs(int x, int y, int roomnum, boolean[][] visited, int[][] map,int N, int M, int[][][] wallarr) {
		Queue<Node> queue = new LinkedList<>();
		queue.add(new Node(x,y));
		visited[x][y] = true;
		int[] dx = {0,-1,0,1};
		int[] dy = {-1,0,1,0};//서북동남
		int roomcnt = 0;
		ArrayList<Node> wall = new ArrayList<>();
		while(!queue.isEmpty()) {
			Node node = queue.poll();
			roomcnt++;
			wall.add(new Node(node.x,node.y));
			for (int i = 0; i < 4; i++) {
				int nx = node.x + dx[i];
				int ny = node.y + dy[i];
				
				if((map[node.x][node.y] & (1<<i)) == 0) {
					//서북동남 체크 1<<i -> 1 2 4 8
					if(nx < 0 || ny < 0 || M <= nx || N <= ny)
						continue;
					
					if(visited[nx][ny])
						continue;
					
					visited[nx][ny] = true;
					queue.add(new Node(nx, ny));
				}
			}
		}
		answer2 = Math.max(roomcnt, answer2);
		for (Node node : wall) {
			wallarr[node.x][node.y][1] = roomcnt;
			wallarr[node.x][node.y][0] = roomnum;
		}
	}
	static void MaxRoom(int M, int N, int[][][] wallarr) {
		int[] dx = {0,-1,0,1};
		int[] dy = {-1,0,1,0};//서북동남
		for (int i = 0; i < M; i++) {
			for (int j = 0; j < N; j++) {
				for (int k = 0; k < 4; k++) {
					int nx = i + dx[k];
					int ny = j + dy[k];
					
					if(nx < 0 || M <= nx || ny < 0 || N<=ny)
						continue;
					
					if(wallarr[i][j][0] != wallarr[nx][ny][0]) {
						answer3 = Math.max(answer3, wallarr[i][j][1] + wallarr[nx][ny][1]);
					}
				}
			}
		}
	}
}
