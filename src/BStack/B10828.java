package BStack;

import java.util.Scanner;

public class B10828 {
	public static int[] stack;
	public static int size = 0;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		System.out.println("시작");
		int N = sc.nextInt();
		
		stack = new int[N];
		
		for(int i = 0; i<N;i++) {
			String str =sc.next();
			
			switch (str) {
			case "push":
				int num = sc.nextInt();
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
			case "top":
				sb.append(Top()+"\n");
				break;
			}
			
		}
		System.out.println(sb);
	}
	static void Push(int num) {
		stack[size] = num;
		size++;
	}
	static int Pop() {
		if(size==0) {
			return -1;
		}
		int k = stack[size-1];
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
	static int Top() {
		if(size==0)
			return -1;
		return stack[size-1];
	}
}

