import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_»ç´Ù¸®_2022 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		double x = Double.parseDouble(st.nextToken());
		double y = Double.parseDouble(st.nextToken());
		double c = Double.parseDouble(st.nextToken());
		
		if(x<y) {
			double temp = x;
			x = y;
			y = temp;
		}
		
		double w1 = 0;
		double w2 = y;
		while(true) {
			double avg_w = (w1 + w2)/2;
			
			double a = Math.sqrt(x*x - avg_w * avg_w);
			double b = Math.sqrt(y*y - avg_w * avg_w);
			
			double answer_c = a*b/(a+b);
			
			if(Math.abs(answer_c - c)<=0.001) {
				System.out.println(avg_w);
				return;
			}
			if(answer_c>c) {
				w1 = avg_w;
			}
			else {
				w2 = avg_w;
			}
		}
	}
}
