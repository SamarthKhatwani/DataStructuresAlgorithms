package arraysandstrings;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.BitSet;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class ArrayString {
	
	public static boolean isUniqueSimple(final String str) {
		
		int[] charCount = new int[256];
		for(int i=0;i<str.length();i++) {
			if(charCount[str.charAt(i)]<1) {
				charCount[str.charAt(i)]++;
			}
			else {
				return false;
			}
			
		}
		
	
		return true;
	}
	
	/**assume that the input string has all lowercase characters**/
	 public static boolean isUniqueBitVector(final String str) {
		 int charChecker=0;
		 for(int i=0;i<str.length();i++) {
			 if((charChecker & (1<< (str.charAt(i)-'a')))<1) {
				 charChecker |= (1<< (str.charAt(i)-'a'));
			 }
			 else {
				 return false;
			 }
		 }
		 return true;
	 }
	 
	 public static boolean isPermutation(final String a, final String b) {
		 
		 if(a.length()!=b.length()) {
			 return false;
		 }
		 int[] charCount= new int[256];
		 for(int i=0;i<a.length();i++) {
			 charCount[(a.charAt(i))]++;
		 }
		 
		 for(int i=0;i<b.length();i++) {
			 charCount[b.charAt(i)]--;
			 
			 if(charCount[b.charAt(i)]<0) {
				 return false;
			 }
		 }
		 return true;
	 }
	 
	 public static boolean palindromePermutationSimple(String str) {
		 
		 int charCount[]= new int[256];
		 
		 for(int i=0;i<str.length();i++) {
			 if(str.charAt(i)==' ') {
				 continue;
			 }
			 else {
				 if(charCount[str.charAt(i)]==0) {
					 charCount[str.charAt(i)]++;
				 }
				 else {
					 charCount[str.charAt(i)]--;
				 }
				 
			 }
		 }
		 
		 int count=0;
		 for(int i=0;i<charCount.length;i++) {
			
			 if(charCount[i]>0) {
				 count++;
				 if(count>1) {
					 return false;
				 }
				 
			 }
			 
			 
		 }
		 return true;
	 }
	 
	 public static boolean oneAwayFT(String a, String b) {
		 BitSet bitSetA=new BitSet(27);
		 BitSet bitSetB=new BitSet(27);
		 for(int i=0;i<a.length();i++) {
			 bitSetA.set((a.charAt(i)-'a'));
		 }
		 
		 for(int i=0; i<b.length();i++) {
			 bitSetB.set((b.charAt(i)-'a'));
		 }
		 
		if(a.length()==b.length()) {
			bitSetA.and(bitSetB);
			System.out.println("Difference in the edits of two strings "+a+" and "+b+" is- "+(a.length()-bitSetA.cardinality()));
			if(a.length()-bitSetA.cardinality()>1) {
				return false;
			}
			else {
				return true;
			}
		}
		else 
		{
			bitSetA.xor(bitSetB);
			System.out.println("Difference in the edits of two strings "+a+" and "+b+" is- "+bitSetA.cardinality());
			if(bitSetA.cardinality()>1) {
				return false;
			}
		 
			return true;
		}
	 }
	 
	 public static int makeAnagrams(String a, String b) {
		 
		 int charCount[]= new int[27];
		 for(int i=0;i<a.length();i++) {
			 charCount[(a.charAt(i)-'a')]++;
		 }
		 for(int i=0;i<b.length();i++) {
			 
				 charCount[(b.charAt(i)-'a')]--;
			 
		 }
		 
		 int finalCount=0;
		 for(int i=0;i<charCount.length;i++) {
			 finalCount=finalCount+  (charCount[i]<0? (-1)*(charCount[i]):charCount[i]);
		 }
		 
		 return finalCount;
	 }
	 
	 public static int alternatingCharacters(String s) {
		 char prevChar='\0';
		 int deleteCount=0;
		 for(int i=0;i<s.length();i++) {
			 if(s.charAt(i)==prevChar) {
				 deleteCount++;
			 }
			 else {
				 prevChar=s.charAt(i);
			 }
		 }
		 
		 return deleteCount;
	 }
	 public static String sherlockStringFT(String s) {
		 HashMap<Character,Integer> charCountMap= new HashMap<>();
         for(int i=0;i<s.length();i++) {
             if(charCountMap.containsKey(s.charAt(i))) {
                 charCountMap.put(s.charAt(i), (charCountMap.get(s.charAt(i))+1));
             }
             else {
                 charCountMap.put(s.charAt(i),1);
             } 
         }
         
         Integer [] arr=charCountMap.values().toArray(new Integer[charCountMap.keySet().size()]);
         
         Arrays.sort(arr);
         int prevCount=arr[0];
          int sameCount=1;
         int count=0;
         int up=0;
         for(int i=1;i<arr.length;i++) {
             count=arr[i];
             sameCount++;
             if(count==prevCount) {
                if(up>1 && sameCount>1) {
                    return "NO";
                }
                
             }
             else if(count>prevCount){
                    if(up>0) {
                        return "NO";
                    }
                    else {
                        up++;
                    }
                }
             else {
                 return "NO";
             }
             prevCount=count;
         }
         return "YES";

	 }
	 
	 public static int findSubStrings(String s) {
		ArrayList<String> stringList= new ArrayList<>();
		 for(int i=0;i<s.length();i++) {
			for(int j=i+1;j<s.length()+1;j++) {
				stringList.add(s.substring(i,j));
			}
		}
		for(String str:stringList) {
			System.out.println(str);
		}
		 
		return stringList.size();
	 }
	 public static int calls2=0;
	 private static void permutationHelper(StringBuilder s, ArrayList<Character> chosen) {
		 calls2++;
		 if(s.length()==0) {
			for(Character c:chosen) {
				System.out.printf(c.toString()+" ");
			}
		 }
		 else {
			 for(int i=0;i<s.length();i++) {
				 
				 Character ch=s.charAt(i);
				 chosen.add(ch);
				 s.delete(i,i+1);
				 
				 permutationHelper(s,chosen);
				 
				 chosen.remove(chosen.size()-1);
				 s.insert(i, ch);
				 
				 
				 
			 }
			 System.out.println();
			 
		 }
		 
	 }
	  public static void printAllPermutationsFT(String s) {
		 ArrayList<Character> chosen = new ArrayList<>();
		 StringBuilder sb = new StringBuilder(s);
		 permutationHelper(sb,chosen);
	 }
	 
	 public static int calls=0;
	 
	 private static void  dieOutcomeHelper(int dice, String outcomes, int desiredSum) {
		 calls++;
		 if(dice==0) {
			if(desiredSum==0) {
				System.out.printf(outcomes);
				System.out.printf(" ");
			}
		 }
		 else if(desiredSum>= dice*1 && desiredSum<= dice*6 ) {
			 for(int i=1;i<=6;i++) {
			//	 String newOutcomes=outcomes+(String.valueOf(i));
				 //Back Tracking step 1- choose
				 outcomes=outcomes+(String.valueOf(i));
				 
				// Back Tracking step 2- explore
				 dieOutcomeHelper(dice-1,outcomes,desiredSum-i); 
				
				//Back Tracking step 3- remove
				 outcomes=outcomes.substring(0, outcomes.length()-1);  
			 }
		//	 System.out.println();
		 }
		 
	 }
	 
	 
	 /**
	  * Print all the outcomes which satisfies the desired sum
	  * @param dice
	  * @param desiredSum
	  */
	 public static void printDieOutcomes(int dice, int desiredSum) {
		 String outcomes = "";
		 dieOutcomeHelper(dice,outcomes,desiredSum);
		 
	 }
	 
	 public static void findAllSublists(ArrayList<String> list) {
		 
		 ArrayList<String> chosenSet= new ArrayList<>();
		 findAllSublistsHelper(list,chosenSet);
		 
		 
		 
		 
	 }
	 
	 private static void findAllSublistsHelper(ArrayList<String> list, ArrayList<String> chosenSet) {
		 
		 if(list.size()==0) {
			 
			for(String s:chosenSet) {
				System.out.printf(s);
				System.out.printf(" ");
			}
		 }
		 else {
			// for(int i=0;i<list.size();i++) {
				 // step 1 choose element
				 String s=list.get(0);
				 list.remove(0);
				 
				 findAllSublistsHelper(list, chosenSet);
				 
				 chosenSet.add(s);
				 
				 findAllSublistsHelper(list, chosenSet);
				 
				 
				 //step 3 unchoose
				 list.add(0, s);
				 chosenSet.remove(s);
				
				 
				 
		//	 }
			 
			// System.out.println();
			 
			 
		 }
		 
		 System.out.println();
	 }
}
