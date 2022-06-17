import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_토너먼트_1057 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		
		int N = Integer.parseInt(st.nextToken());
		int num1 = Integer.parseInt(st.nextToken());
		int num2 = Integer.parseInt(st.nextToken());
		int round = 0;
		
		while(num1 != num2) {
			num1 = num1 / 2 + num1 % 2;
			num2 = num2 / 2 + num2 % 2;
			round++;
		}
		System.out.println(round);
	}

}
