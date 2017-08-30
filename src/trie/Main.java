package trie;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
     Trie trie = new Trie();
     trie.insert("How");
     trie.insert("HowZatt");
     trie.insert("Ram");
     trie.insert("Ramayan");
     trie.search("Ram");
     trie.search("How");
     trie.search("How");
     trie.search("How");
     trie.search("How");
     trie.search("How");
     trie.search("How");
     trie.search("HowZatt");
     trie.search("HowZatt");
     trie.search("HowZatt");
     trie.search("HowZatt");
     trie.printAutoSuggest(trie.root, "Ho");
     trie.insert("base");
     trie.insert("basement");
     trie.getMatchingPrefix(trie.root, "basemexy");
     
     
	}

}
