import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_봄버맨_16918 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int R = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());
		
		char[][] map = new char[R][C];
		int[][] bombtime = new int[R][C];
		
		for (int i = 0; i < R; i++) {
			String temp = br.readLine();
			for (int j = 0; j < C; j++) {
				map[i][j] = temp.charAt(j);
				if(map[i][j]=='O'){
                    bombtime[i][j] = 3;
                }
			}
		}
		int time = 0;
		while(time++ < N) {
			int num = time % 2;
			switch (num) {
			case 0:
				for (int i = 0; i < R; i++) {
                    for (int j = 0; j < C; j++) {
                        if (map[i][j] == '.') {
                            map[i][j] = 'O';
                            bombtime[i][j] = time+3;
                        }
                    }
                }
				break;
			case 1:
				int[] dx = {-1,0,1,0};
				int[] dy = {0,-1,0,1};
				for (int i = 0; i < R; i++) {
                    for (int j = 0; j < C; j++) {
                        if (bombtime[i][j] == time) {
                            map[i][j] = '.';
                            for (int d = 0; d < 4; d++) {
                                int ni = i + dx[d];
                                int nj = j + dy[d];

                                if (ni < 0 || nj < 0 || ni >= R || nj >= C)
                                	continue;
                                if(map[ni][nj]=='O' && bombtime[ni][nj] != time) { 
                                    map[ni][nj] = '.';
                                    bombtime[ni][nj] = 0;
                                }
                            }
                        }
                    }
                }
				break;
			}
			
			
		}
		
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				System.out.print(map[i][j]);
			}
			System.out.println();
		}
		
	}
}
