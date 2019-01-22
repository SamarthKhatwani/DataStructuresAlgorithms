import java.util.ArrayList;
import java.util.Scanner;

import arraysandstrings.ArrayString;

public class TestArrayAndStrings {

	public static void mainTestArrayAndStrings(String[] args) {
		// TODO Auto-generated method stub
		String s="abcdefgha";
		System.out.println(ArrayString.isUniqueSimple(s));
		System.out.println(ArrayString.isUniqueBitVector(s));
		
		String a="abcadef";
		String b="aabcdeg";
		System.out.println("Permutation checker- "+ArrayString.isPermutation(a, b));
		String permPalindrome="tactcoapapa";
		System.out.println("Permutation palindrome checker for string- "+permPalindrome+" "+ArrayString.palindromePermutationSimple(permPalindrome));
		
		String s1="pales";
		String s2="pale";
		
		String s3="fcrxzwscanmligyxyvym";
		String s4="jxwtrhvujlmrpdoqbisbwhmgpmeoke";
		System.out.println(ArrayString.oneAwayFT(s1,s2));
		System.out.println(ArrayString.oneAwayFT(s3,s4));
		System.out.println("Make Anagrams for strings - "+s3+" and "+s4+" - "+ArrayString.makeAnagrams(s3, s4));
		String altChar1="AAABBB";
		System.out.println("Presence of alternating characters for string "+altChar1+" - "+ArrayString.alternatingCharacters(altChar1));
		
	//	String sherlockString1="aabbc";
	//	Scanner sc= new Scanner(System.in);
	//	String input1=sc.next();
	//	System.out.println("Is it a Sherlock string test for "+sherlockString1+" - "+ArrayString.sherlockStringFT(input1));
		String sstring="abcd";
		System.out.println("Number of subtring of "+sstring+" is- "+ArrayString.findSubStrings(sstring));
		

		ArrayString.printDieOutcomes(3,7);
		System.out.println();
		System.out.println("total calls -"+ArrayString.calls);
		
		String permute="abcd";
		System.out.println("Total permutaions of "+permute+" ");
		ArrayString.printAllPermutationsFT(permute);
		System.out.println(ArrayString.calls2);
		
		ArrayList<String> slist= new ArrayList<>();
		slist.add("Jane");
		slist.add("Bob");
		slist.add("Matt");
		slist.add("Sara");
		System.out.println("Total sublists -{Jane, Bob, Matt, Sara} ");
		ArrayString.findAllSublists(slist);
		
	}

}
