import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_거스름돈_14916 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int count =0;
		
		while(N>0) {
			if(N % 5 == 0) {
				count = N/5 + count;
				break;
			}
			N-=2;
			count++;
		}
		if(N<0) {
			System.out.println(-1);
		}
		else {
			System.out.println(count);
		}
	}
}
