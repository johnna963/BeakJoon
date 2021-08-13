package BQueue;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;


public class B18258 {
	public static int[] queue = new int[2000000];
	public static int size = 0;
	public static int front = 0;
	public static int back = 0;
	
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st;
		int N = Integer.parseInt(br.readLine());
		
		
		for(int i = 0; i<N;i++) {
			st = new StringTokenizer(br.readLine()," ");
			switch (st.nextToken()) {
			case "push":
				int num = Integer.parseInt(st.nextToken());
				Push(num);
				break;
			case "pop":
				sb.append(Pop()+"\n");
				break;
			case "size":
				sb.append(Size()+"\n");
				break;
			case "empty":
				sb.append(Empty()+"\n");
				break;
			case "front":
				sb.append(Front()+"\n");
				break;
			case "back":
				sb.append(Back()+"\n");
				break;
			}
			
		}
		System.out.println(sb);
	}
	
	static void Push(int num) {
		queue[back] = num;
		size++;
		back++;
	}
	static int Pop() {
		if(size==0) {
			return -1;
		}
		int k = queue[front];
		front++;
		size--;
		return k;
	}
	static int Size() {
		return size;
	}
	static int Empty() {
		if(size==0)
			return 1;
		
		return 0;
	}
	static int Front() {
		if(size==0)
			return -1;
		return queue[front];
	}
	
	static int Back() {
		if(size==0)
			return -1;
		return queue[back-1];
	}
}