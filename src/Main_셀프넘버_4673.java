import java.util.Arrays;

public class Main_셀프넘버_4673 {

	public static void main(String[] args) {
		boolean[] visit = new boolean[10001];
		Arrays.fill(visit, false);
		for(int i = 1; i< 10001;i++) {
			int n = d(i);
			if(n<10001) {
				visit[n] = true;
			}
		}
		for(int i = 1; i<10001;i++) {
			if(!visit[i]) {
				System.out.println(i);
			}
		}
	}
	static int d(int num) {
		int sum = num;
		while(num!=0) {
			sum += num %10;
			num /=10;
		}
		return sum;
	}

}
