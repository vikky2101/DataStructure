package linkedlist;

import java.util.Iterator;
import java.util.LinkedList;

public class Main {

	public static void moveVowelEnd(LinkedList<Character> list) {
		if (list == null)
			return;
		int size = list.size();
		for (int i = 0; i < size; i++) {
			if ("aeoiuAEOIU".indexOf(list.get(i)) != -1) {
				list.add(list.get(i));
				list.remove(i);
				size--;
			}
		}
	}

	public static void main(String args[]) {
		LinkedList<Character> list = new LinkedList<>();
		list.add('E');
		list.add('W');
		list.add('A');
		list.add('Q');
		list.add('U');
		list.add('R');
		Iterator<Character> iterator;
		iterator = list.iterator();
		while (iterator.hasNext())
			System.out.print(iterator.next() + " ");
		moveVowelEnd(list);
		System.out.println();
		iterator = list.iterator();
		while (iterator.hasNext())
			System.out.print(iterator.next() + " ");

		LinkedList<Integer> numList = new LinkedList<>();
		numList.add(3);
		numList.add(5);
		numList.add(6);
		numList.add(2);
		numList.add(11);
		numList.add(13);
		numList.add(15);
		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i));
		}
		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i));
		}
		System.out.println();
		// LInkedList Generic
		MyLinkedList<Integer> linkedList = new MyLinkedList<>();
		linkedList.insertEnd(new LinkedListNode<Integer>(15));
		linkedList.insertEnd(new LinkedListNode<Integer>(10));
		linkedList.insertEnd(new LinkedListNode<Integer>(5));
		linkedList.insertEnd(new LinkedListNode<Integer>(20));
		linkedList.insertEnd(new LinkedListNode<Integer>(3));
		linkedList.insertEnd(new LinkedListNode<Integer>(2));
       linkedList.printLinkedList();		
       System.out.println();
       
       MyLinkedList<Integer> sortList = new MyLinkedList<>();
       sortList.insertEnd(new LinkedListNode<Integer>(2));
       sortList.insertEnd(new LinkedListNode<Integer>(0));
       sortList.insertEnd(new LinkedListNode<Integer>(1));
       sortList.insertEnd(new LinkedListNode<Integer>(2));
       sortList.insertEnd(new LinkedListNode<Integer>(0));
       sortList.insertEnd(new LinkedListNode<Integer>(1));
       sortList.insertEnd(new LinkedListNode<Integer>(2));
       sortList.insertEnd(new LinkedListNode<Integer>(0));
       sortList.printLinkedList();
       LinkedListNode<Integer> newhead= sortList.sort_0_1_2(sortList);
      while(newhead != null){
    	  System.out.println(newhead.getKey());
    	  newhead = newhead.getNext();
      }
      	

	}
}
