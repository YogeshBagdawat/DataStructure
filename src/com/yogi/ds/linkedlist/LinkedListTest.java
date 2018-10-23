package com.yogi.ds.linkedlist;

public class LinkedListTest {

	public static void main(String[] args) {
		LinkedList l1 = new LinkedList();
		/*list.insertAtBegining(5);
		//list.dispaly();
		list.insertAtEnd(6);
		list.insertAtEnd(2);
		list.insertAtEnd(9);
		list.insertAfter(2, 3);
		list.insertAfter(6, 7);
		list.insertAtBegining(11);
		list.insertAtBegining(21);
		list.dispaly();
		System.out.println(list.isPresent(7));
		System.out.println(list.sizeRecursive());
		//list.delete(7);
		//list.deleteAtpos(8);
		//System.out.println(list.isPresent(7));
		//System.out.println(list.sizeRecursive());
		//list.swapNodes(21, 15);
		list.reverseLinkedList();*/
		LinkedList l2 = new LinkedList();
		l1.insertAtEnd(7);
		l1.insertAtEnd(9);
		l2.insertAtEnd(11);
		l2.insertAtEnd(17);
		LinkedList l3 = l1.mergeTwoSortedList(l1, l2);
		l3.dispaly();
	
	}

}
