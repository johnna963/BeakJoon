import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main_필터 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int cnt = 0;
		int R = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());
		int[][] arr = new int[R][C];
		
		for (int i = 0; i < R; i++) {
			String[] str = br.readLine().split(" ");
			for (int j = 0; j < C; j++) {
				arr[i][j] = Integer.parseInt(str[j]);
			}
		}
		int T = Integer.parseInt(br.readLine());
		
		for (int i = 0; i <= R - 3; i++) {
			for (int j = 0; j <= C - 3; j++) {
				ArrayList<Integer> list = new ArrayList<>();
				for (int k = 0; k < 3; k++) {
					for (int l = 0; l < 3; l++) {
						list.add(arr[i+k][j+l]);
					}
				}
				Collections.sort(list);
//				for (int k = 0; k < list.size(); k++) {
//					System.out.print(list.get(k)+" ");
//				}
//				System.out.println();
				int K = list.get(4);
				if(K>=T) {
					cnt++;
				}
			}
		}
		System.out.println(cnt);
	}
}
