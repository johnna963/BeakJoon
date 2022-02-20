import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main_문자열폭발_9935 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		String exstr = br.readLine();
		int len = str.length();
		int exlen = exstr.length();
		Stack<Character> st = new Stack<>();
		
		for(int i = 0; i < len; i++) {
			char c = str.charAt(i);
			st.add(c);
			if(st.size()>=exlen) {
				boolean check = true;
				for(int j = 0; j < exlen;j++) {
					char c1 = st.get(st.size() - exlen + j);
					char c2 = exstr.charAt(j);
					if(c1!=c2) {
						check = false;
						break;
					}
				}
				if(check) {
					for(int k = 0 ; k<exlen;k++) {
						st.pop();
					}
				}
			}
		}
		if(st.size()==0) {
			System.out.println("FRULA");
		}else {
			StringBuilder sb = new StringBuilder();
			for(int i = 0; i< st.size(); i++) {
				sb.append(st.get(i));
			}
			System.out.println(sb.toString());
		}
	}
}
