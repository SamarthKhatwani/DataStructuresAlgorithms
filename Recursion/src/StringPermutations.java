import java.util.Collections;

public class StringPermutations {

	public static void printPermutations(String str) {
		permutations(str,"");
	}
	
	private static void permutations(String str, String prefix) {
		Collections.sort(list);
		if(str.length()==0) {
			System.out.println(prefix);
		}
		else {
			for(int i=0;i<str.length();i++) {
				permutations(str.substring(0, i)+str.substring(i+1, str.length()),prefix+str.charAt(i));
			}
		}
	}
}
