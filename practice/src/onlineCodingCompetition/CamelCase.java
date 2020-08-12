package onlineCodingCompetition;

import java.util.HashMap;
import java.util.Map;

public class CamelCase {

	static Map<Character,Integer> lookup;
	static int counter;
	static void preprocess(String pattern) {
		lookup = new HashMap<>();
		char[] patternArray = pattern.toCharArray();
		for(char c: patternArray) {
			if(!lookup.containsKey(c)) {
				lookup.put(c,1);
			}else {
				int val = lookup.get(c);
				lookup.put(c, val+1);
			}
			counter++;
		}
		
	}
	static void findMatch(String[] dict) {
		for(String word: dict) {
			if(matcher(word)) {
				System.out.println(word);
			}
		}
	}
	
	static boolean matcher(String word) {
		boolean answer = false;
		char[] wordArray = word.toCharArray();
		Map<Character,Integer> localLookup = new HashMap<>(lookup);
		int localCounter = counter;
		for(char c: wordArray) {
			if(localLookup.containsKey(c)) {
				int currFreq = localLookup.get(c);
				if(currFreq>0) {
					localLookup.put(c,currFreq-1);
					localCounter--;
				}
			}
		}
		if(localCounter<=0) {
			answer = true;
		}
		return answer;
	}
	public static void main(String[] args) {
		String dict[] = {"Hi", "Hello", "HelloWorld",  "HiTech", "HiGeek", 
		                 "HiTechWorld", "HiTechCity", "HiTechLab"};
		String pat = "HT";
		lookup = new HashMap<Character, Integer>();
		preprocess(pat);
		findMatch(dict);
	}

}
