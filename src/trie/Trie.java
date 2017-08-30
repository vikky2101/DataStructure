package trie;

import java.util.HashMap;

public class Trie {
	
	TrieNode root;
	public Trie(){
		root = new TrieNode((char)0);
	}
	
	public void insert(String word){
		int len = word.length();
		TrieNode crawl = root; 
		for(int i = 0 ; i< len ;i++){
			HashMap<Character, TrieNode> children = crawl.getChildren();
			char ch = word.charAt(i);
			if(children.containsKey(ch))
				crawl = children.get(ch);
			else{
				TrieNode temp = new TrieNode(ch);
				children.put(ch, temp);
				crawl = temp;	
			}
		}
		crawl.seEnd(true);
	}
	
	public boolean search(String word){
		int len = word.length();
		TrieNode crawl = root;
		for(int i = 0 ; i<len; i++){
			HashMap<Character, TrieNode> children = crawl.getChildren();
			char ch = word.charAt(i);
			if(!children.containsKey(ch))
				return false;
				crawl = children.get(ch);
		}
			if(crawl != null && crawl.checkIsEnd())
			{
				crawl.increHitCount();
				return true;
			}
			return false;
		
	}
	
	private void suggestWords(TrieNode root, String prefix){
		if(root.checkIsEnd()){
			System.out.println(prefix +" "+ root.getHit());
		}
		HashMap<Character, TrieNode> children = root.getChildren();
		for(Character ch : children.keySet()){
			prefix += children.get(ch).getValue();
			suggestWords(children.get(ch), prefix);
		}
	}
	
	public void printAutoSuggest(TrieNode root, String prefix){
		int len = prefix.length();
		TrieNode crawl = root;
		for(int i = 0 ; i<len; i++){
			HashMap<Character, TrieNode> children = crawl.getChildren();
			char ch = prefix.charAt(i);
			if(!children.containsKey(ch)){
				System.out.println("No Words exists for this prefix");
				return ;
			}	
				crawl = children.get(ch);
		}
		
		if(crawl != null && crawl.checkIsEnd()){
			System.out.println("No Words exists for this prefix");
			return;
		}
		else
		   suggestWords(crawl, prefix);
		
	}
	
	public void getMatchingPrefix(TrieNode root, String prefix){
		int len = prefix.length();
		int matchIndex = 0;
		TrieNode crawl = root;
		for(int i = 0 ; i<len; i++){
			HashMap<Character, TrieNode> children = crawl.getChildren();
			char ch = prefix.charAt(i);
			if(children.containsKey(ch)){
				crawl = children.get(ch);
				if(crawl.checkIsEnd())
					matchIndex = i + 1;
			}	
			else
				break;
		}
		
		if(crawl != null && !crawl.checkIsEnd()){
		  System.out.println(prefix.substring(0, matchIndex));
		}
		else
		   System.out.println(prefix);
	}
}
