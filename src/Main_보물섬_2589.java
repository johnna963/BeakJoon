import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Main_보물섬_2589 {
	static class Pos{
		int x;
		int y;
		int cnt;
		public Pos(int x, int y, int cnt) {
			this.x = x;
			this.y = y;
			this.cnt = cnt;
		}
	}
	static int r;
	static int c;
	static char[][] map;
	static int[] dx = {-1,0,1,0};
	static int[] dy = {0,-1,0,1};
	static boolean[][] visit;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		map = new char[r][c];
		visit = new boolean[r][c];
		for (int i = 0; i < r; i++) {
			String str = br.readLine();
			for (int j = 0; j < c; j++) {
				map[i][j] = str.charAt(j);
			}
		}
		int res = 0;
		
		for (int i = 0; i < r; i++) {
			for (int j = 0; j < c; j++) {
				if(map[i][j] == 'L') {
					visit = new boolean[r][c];
					int val = bfs(i,j);
					res = Math.max(res, val);
				}
			}
		}
		System.out.println(res);
	}
	static int bfs(int x, int y) {
		Queue<Pos> queue = new LinkedList<>();
		int val = 0;
		visit[x][y] = true;
		queue.add(new Pos(x,y,0));
		while (!queue.isEmpty()) {
			Pos pos = queue.poll();
			for (int i = 0; i < 4; i++) {
				int nx = pos.x + dx[i];
				int ny = pos.y + dy[i];
				
				if(0<= nx && nx < r && 0<=ny && ny<c 
						&& !visit[nx][ny] && map[nx][ny] =='L' ) {
					visit[nx][ny] = true;
					queue.add(new Pos(nx, ny, pos.cnt + 1));
					val = Math.max(val, pos.cnt+1);
				}
			}
		}
		return val;
		
	}
	
}
