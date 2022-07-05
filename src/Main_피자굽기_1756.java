import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_피자굽기_1756 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		int D = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());
		int[] arr = new int[D];
		st = new StringTokenizer(br.readLine()," ");
		
		for (int i = 0; i < D ; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		for (int i = 1; i < D; i++) {
			if(arr[i] > arr[i-1]) {
				arr[i] = arr[i-1];
			}
		}
		Arrays.sort(arr);
		st = new StringTokenizer(br.readLine());
		int answer = 0;
		int lowidx = -1;
		for (int i = 0; i < N; i++) {
			int pizza = Integer.parseInt(st.nextToken());
			lowidx = binarySearch(arr, pizza, lowidx);
			if(lowidx == -1) break;
		}
		if(lowidx != -1) {
			answer = D - lowidx;
		}
		System.out.println(answer);
	}
	static int binarySearch(int[] oven, int pizza, int idx) {
		boolean flag = false;
		int top = oven.length-1;
		int bottom = idx+1;
		while(bottom < top) {
			int mid = (bottom + top) / 2;
			if(oven[mid] < pizza) {
				bottom  = mid + 1;
			}
			else {
				top = mid;
				flag = true;
			}
		}
		if(flag) return top;
		
		else {
			return -1;
		}
	}
}
