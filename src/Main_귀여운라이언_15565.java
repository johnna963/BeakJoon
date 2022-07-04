import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_귀여운라이언_15565 {
	//파라메트릭서치?
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int[] arr = new int[N+1];
		st = new StringTokenizer(br.readLine()," ");
	
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		int start = K;
		int end = N;
		int answer = Integer.MAX_VALUE;
		while(start <= end) {
			int mid = (start + end)/2;
			int[] cnt = new int[3];
			
			for (int i = 0; i < mid-1; i++) {
				cnt[arr[i]]++;
			}
			boolean isFind = false;
			
			for (int i = mid-1; i < N; i++) {
				cnt[arr[i]]++;
				if(cnt[1] >=K) {
					end = mid - 1;
					answer = Integer.min(answer, mid);
					isFind = true;
					break;
				}
				cnt[arr[i+1-mid]]--;
			}
			if(!isFind) {
				start = mid+1;
			}
		}
		if(answer == Integer.MAX_VALUE) {
			answer = -1;
		}
		System.out.println(answer);
	}
}
