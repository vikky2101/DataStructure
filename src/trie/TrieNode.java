package trie;

import java.util.HashMap;

class TrieNode {
	private char value;
	private HashMap<Character, TrieNode> children;
	private boolean isEnd;
	private int count;
	
	public TrieNode(char ch){
		this.value = ch;
		children = new HashMap<>();
		isEnd = false;
	}
	
	public HashMap<Character, TrieNode> getChildren(){
		return children;
	}
	
	public char getValue(){
		return this.value;
		
	}
	
	public void seEnd(boolean flag){
		this.isEnd = flag;
	}
	
	public boolean checkIsEnd(){
		return this.isEnd;
	}
	public void increHitCount(){
		this.count++;
	}
	
	public int getHit(){
		return this.count;
	}
	
}
