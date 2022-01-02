import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_블랙잭_2798 {
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		int[] arr = new int[N];
		for(int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		System.out.println(search(arr,N,M));
	}
	static int search(int[] arr, int N, int M) {
		int res = 0;
		for(int i = 0; i < N - 2; i++) {
			for(int j = i+1; j < N - 1; j++) {
				for(int k = j+1; k < N; k++) {
					int num = arr[i] + arr[j] + arr[k];
					
					if(M == num) {
						return num;
					}
					if(res < num && num < M) {
						res = num;
					}
				}
			}
		}
		return res;
	}
}
