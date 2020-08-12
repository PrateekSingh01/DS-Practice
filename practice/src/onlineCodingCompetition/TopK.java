package onlineCodingCompetition;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class TopK {
	public static ArrayList<String> popularNToys(int numToys, int topToys, List<String> toys, int numQuotes,
			List<String> quotes) {
		Map<String, Integer> counter = new HashMap<>();
		for (String quote : quotes) {
			if (toys.contains(quote.toLowerCase())) {
				if (!counter.containsKey(quote)) {
					counter.put(quote, 1);
				} else {
					counter.replace(quote, counter.get(quote) + 1);
				}
			}
		}
		PriorityQueue<String> pq = new PriorityQueue<>((w1,
				w2) -> counter.get(w1).equals(counter.get(w2)) ? w1.compareTo(w2) : counter.get(w1) - counter.get(w2));
		for (String toy : counter.keySet()) {
			pq.offer(toy);
			if (pq.size() > topToys) {
				pq.poll();
			}
		}
		ArrayList<String> ans = new ArrayList<>();
		while (!pq.isEmpty()) {
			ans.add(pq.poll());
		}
		  System.out.print(pq.size());
		     System.out.print(ans.size());
		for (String an : ans) {
			System.out.println(an);
		}
		Collections.reverse(ans);
		return ans;
	}

	public static void main(String[] args) {
		List<String> wordDict = Stream.of("elmo", "elsa", "abc","z").map(x->x.charAt(0)+"").collect(Collectors.toList());
		List<String> quote = Stream.of("z","z","z","z","Elmo", "Elsa", "Elmo", "Elsa", "Elmo", "Elsa", "abc")
				.collect(Collectors.toList());

		ArrayList<String>ans = popularNToys(3, 2, wordDict, 2, quote);
		for (String an : ans) {
			System.out.println(an);
		}
	}

}
