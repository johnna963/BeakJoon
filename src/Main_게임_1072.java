import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_게임_1072 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		long x = Long.parseLong(st.nextToken());
		long y = Long.parseLong(st.nextToken());
		long z = 100 * y / x;		
		long left = 1;
		long right = x;
		if(z>=99) {
			System.out.println(-1);
		}
		else {
			while(left<=right) {
				
				long mid = (left + right)/2;
				long ratio = (y + mid) * 100 / (x+mid);
				
				if(ratio > z) {
					right = mid -1;
				}
				else {
					left = mid + 1;
				}
			}
			System.out.println(left);
		}
	}
}
