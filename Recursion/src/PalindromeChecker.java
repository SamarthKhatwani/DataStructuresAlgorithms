
public class PalindromeChecker {
	 
	public static boolean checkForPalindrome(String s,int startIndex, int endIndex) {
		if(s.charAt(startIndex)==s.charAt(endIndex)) {
			if(startIndex==endIndex|| (startIndex+1)==endIndex) {
				return true;
			}
			else {
				return checkForPalindrome(s,++startIndex,--endIndex);
			}
		}
		else {
			return false;
		}
	}
	
	public static boolean checkForPalindromeHelper(String str) {
		int startI=0;
		int endI=str.length()-1;
		return checkForPalindrome(str, startI, endI);
	}

}
