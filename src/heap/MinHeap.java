package heap;

import java.util.ArrayList;

public class MinHeap <T>{
	private ArrayList<T> list;
	
	public MinHeap(){
		this.list = new ArrayList<T>();
	}
	
	public MinHeap(ArrayList<T> items){
		this.list = items;
		buildHeap();
	}
	
	public void buildHeap(){
		for(int i = this.list.size()/2 ; i >= 0 ; i--)
			minhHeapify(i);
	}
	
	private int parent(int i){
		if(i <= 0)
			return -1;
		else
			return (i-1)/2;
	}
	private void swap(int index, int parent){
		T temp = list.get(index);
		list.set(index, list.get(parent));
		list.set(parent, temp);
	}
	public void minhHeapify(int index){
		int left = 2*index + 1;
		int right = 2*(index+1);
		int smallest = index;
		if(left <= list.size()-1 && (Integer)list.get(left) < (Integer)list.get(index))
			smallest = left;
		if(right <= list.size()-1 && (Integer)list.get(right) < (Integer)list.get(smallest))
			smallest = right;
		if(smallest != index){
			swap(smallest, index);
			minhHeapify(smallest);
		}	
	}
	
	public T getMin(){
		return this.list.get(0);
	}
	
	public void insert(T item){
		this.list.add(item);
		int current = list.size();
		int parent  = parent(current);
		while((Integer)list.get(current) < (Integer)list.get(parent)){
			swap(current, parent);
			current = parent;
			parent = current/2;
		}
	}
	
}
