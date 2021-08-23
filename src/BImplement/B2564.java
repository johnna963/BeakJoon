package BImplement;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class B2564 {
	static int R;
	static int C;
	static int N;
	static int answer;
	static ArrayList<Pos> arr = new ArrayList<Pos>();
	static class Pos{
		int x;
		int y;
		public Pos(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}
		
	}
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		C = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(br.readLine());
		for (int i = 0; i < N+1; i++) {
			st = new StringTokenizer(br.readLine()," ");
			int dir = Integer.parseInt(st.nextToken());
			int block = Integer.parseInt(st.nextToken());
			switch (dir) {
			case 1://블록의 북쪽
				arr.add(new Pos(0,block));
				break;
			case 2://블록의 남쪽
				arr.add(new Pos(R,block));
				break;
			case 3://블록의 서쪽
				arr.add(new Pos(block,0));
				break;
			case 4://블록의 동쪽
				arr.add(new Pos(block,C));
				break;
			}
			//System.out.println(arr.get(i).x+" "+arr.get(i).y);
			
		}
		
		for (int j = 0; j < N; j++) {
			//정반대에 있는지 왼쪽에 있는지 오른쪽에 있는지
			if(Math.abs(arr.get(N).x-arr.get(j).x) == R) {
				answer += R;
				answer += Math.min(arr.get(N).y+arr.get(j).y,
						2*C-arr.get(N).y-arr.get(j).y);
			}
			else if(Math.abs(arr.get(N).y-arr.get(j).y) == C) {
				answer += C;
				answer += Math.min(arr.get(N).x+arr.get(j).x,
						2*R-arr.get(N).x-arr.get(j).x);
			}
			else
			{
				answer += Math.abs(arr.get(N).x-arr.get(j).x);
				answer += Math.abs(arr.get(N).y-arr.get(j).y);
			}
		}
		System.out.println(answer);
	}
}
