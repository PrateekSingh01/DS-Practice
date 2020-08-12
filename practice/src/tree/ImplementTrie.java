package tree;

public class ImplementTrie {

	static class TrieNode{
		TrieNode list[];
		boolean isEnd = false;
		public TrieNode() {
			list = new TrieNode[26];
		}
	}
	static TrieNode root;
	public ImplementTrie() {
		root = new TrieNode();
	}

	/** Inserts a word into the trie. */
	public void insert(String word) {
		TrieNode curr = root;
		for(int i=0;i<word.length();i++) {
			if(curr.list[word.charAt(i)-'a']==null) {
				TrieNode node = new TrieNode();
				curr.list[word.charAt(i)-'a'] = node;
			}
			curr = curr.list[word.charAt(i)-'a'];
		}
		curr.isEnd=true;
	}

	/** Returns if the word is in the trie. */
	public boolean search(String word) {
		TrieNode curr = root;
		for(int i=0;i<word.length();i++){
			if(curr.list[word.charAt(i)-'a']!=null) {
				curr = curr.list[word.charAt(i)-'a'];
			}else {
				return false;
			}
		}
		return curr.isEnd;
	}

	/**
	 * Returns if there is any word in the trie that starts with the given prefix.
	 */
	public boolean startsWith(String prefix) {
		TrieNode curr = root;
		for(int i=0;i<prefix.length();i++){
			if(curr.list[prefix.charAt(i)-'a']!=null) {
				curr = curr.list[prefix.charAt(i)-'a'];
			}else {
				return false;
			}
		}
		return (curr.isEnd==true||hasChild(curr));
	}
	
	public boolean hasChild(TrieNode node) {
		for(int i=0;i<26;i++) {
			if(node.list[i]!=null) {
				return true;
			}
		}
		return false;
	}

	public static void main(String[] args) {
		ImplementTrie o = new ImplementTrie();
		o.insert("a");
		o.search("a");
		o.startsWith("a");

	}

}
