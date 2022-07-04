import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_겉넓이구하기_16931 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		int answer = 0;
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int[][] arr = new int[N][M];
		int[] dx = {-1, 0, 1, 0};
		int[] dy = {0, -1, 0, 1};
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < M; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				for (int k = 0; k < 4; k++) {
					int nx = i + dx[k];
					int ny = j + dy[k];
					
					if(nx < 0 || ny < 0 || nx > N-1 || ny > M-1) {
						answer += arr[i][j];
						continue;
					}
					if(arr[nx][ny] < arr[i][j]) {
						answer += arr[i][j] - arr[nx][ny];
					}
				}
			}
		}
		answer += N * M * 2;
		
		System.out.println(answer);
	}

}
