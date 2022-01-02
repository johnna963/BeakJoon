package BImplement;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class Main_놀라운문자열_1972 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		String str;
		while(true) {
			str = br.readLine();
			if("*".equals(str)) {
				break;
			}
			
			int len = str.length();
			ArrayList<String> arr = new ArrayList<>();
			boolean check = true;
			for (int i = 1; i < len; i++) {
				arr.clear();
				for (int j = 0; j < len - i; j++) {
					String surstr = Character.toString(str.charAt(j)) + Character.toString(str.charAt(j + i));
					arr.add(surstr);
				}
				Collections.sort(arr);
				for (int k = 0; k < arr.size() - 1; k++) {
					if(arr.get(k).equals(arr.get(k + 1))) {
						check = false;
						break;
					}
				}
				if(!check) {
					break;
				}
			}
			if(check) {
				sb.append(str).append(" is surprising.\n");
			}
			else {
				sb.append(str).append(" is NOT surprising.\n");
			}
		}
		System.out.println(sb);
	}
}
