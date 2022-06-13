import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_적록색약_10026 {
	static int[] dx = {-1,0,1,0};
	static int[] dy = {0,-1,0,1};
	static int N;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		char[][] grmap = new char[N][N];//적록색약맵
		boolean[][] grcheck = new boolean[N][N];
		int grcnt = 0;
		char[][] map = new char[N][N];//기본맵
		boolean[][] check = new boolean[N][N];
		int cnt = 0;
		for (int i = 0; i < N; i++) {
			String str = br.readLine();
			for (int j = 0; j < N; j++) {
				char c = str.charAt(j);
				map[i][j] = c;
				if(c == 'G') {
					grmap[i][j] = 'R';
				}
				else {
					grmap[i][j] = c;
				}
			}
		}
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if(!check[i][j]) {
					dfs(i,j,check,map,map[i][j]);
					cnt++;
				}
				if(!grcheck[i][j]) {
					dfs(i,j,grcheck,grmap,grmap[i][j]);
					grcnt++;
				}
			}
		}
		System.out.println(cnt+" "+ grcnt);
	}
	static void dfs(int x, int y, boolean[][] check, char[][] map, char color) {
		check[x][y] = true;
		for (int i = 0; i < 4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			if(nx >= 0 && ny>=0 && nx< N && ny<N
					&& !check[nx][ny] && map[nx][ny] == color) {
				dfs(nx,ny,check,map,color);
			}
		}
	}
}
