import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main_회의실배정_1931 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[][] table = new int[N][2];
		StringTokenizer st;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			table[i][0] = Integer.parseInt(st.nextToken());
			table[i][1] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(table, new Comparator<int[]>() {
			public int compare(int[] o1, int[] o2) {
				if(o1[1]==o2[1]) {
					return o1[0] - o2[0];
				}
				return o1[1] - o2[1];
			}
		});
		
		int count = 0;
		int end_time = 0;
		
		for (int i = 0; i < N; i++) {
			if(end_time <= table[i][0]) {
				end_time = table[i][1];
				count++;
			}
		}
		System.out.println(count);
	}
}
