package com.yogi.ds.linkedlist;
/*
 * linked list implementation in java
 * insert node at beginning
 * insert node end
 * insert node after given node
 * delete node first occurrence of given key
 * delete node at given position
 * size of list (using iterative and recursive)
 * swap nodes in linked list without swapping data 
 * reverse a linked list
 * merge two sorted list
 */
class Node{
	int data;
	Node next;
	Node ()  {
	}
	Node (int data, Node next) {
		this.data = data;
		this.next = next;
	} 
	Node (int data) {
		this.data = data;
		this.next = null;
	}
}
public class LinkedList {
	Node head = new Node();
	Node tail = new Node();
	
	public void insertAtBegining (int data) {
		Node temp = new Node(data);
		if (head.next == null) {
			head.next = temp;
			tail.next = temp;
		}
		else {
			temp.next = head.next;
			head.next = temp;
		}
	}
	
	public void insertAtEnd (int data) {
		Node temp = new Node(data);
		if (head == null) {
			head.next = temp;
			tail.next = temp;
		}
		else {
			Node temp2 = head;
			while (temp2.next != null) {
				temp2 = temp2.next;
			}
			temp2.next = temp;
			tail.next = temp;
		}
	}
	
	public void insertAfter (int data, int newdata) {
		Node ins = new Node(newdata);
		Node temp = head;
		while (temp.data != data) {
			temp = temp.next;
		}
		Node temp2 = temp.next;
		temp.next = ins;
		ins.next = temp2;
		
	}
	
	public void delete(int data){
		Node temp = head;
		while (temp.next != null) {
			if (temp.next.data == data) {
				temp.next = temp.next.next;
				break;
			}
			temp = temp.next;
		}
	}
	
	public void deleteAtpos (int pos) {
		Node temp = head;
		int count = 0;
		if (pos > size() - 1) {
			return ;
		}
		while (count++ < pos) {
			temp = temp.next;
		}
		temp.next = temp.next.next;
	}
	
	public boolean isPresent (int data) {
		Node temp = head;
		while (temp.next != null) {
			if (temp.data == data) {
				return true;
			}
			temp = temp.next;
		}
		return false;
	}
	
	public int size() {
		Node temp = head.next;
		int size = 0;
		while (temp != null) {
			size++;
			temp = temp.next;
		}
		return size;
	}
	
	public int sizeRecursive () {
		Node temp = head.next;
		return sizeRecursive(temp);
	}
	
	
	private int sizeRecursive (Node temp) {
		if (temp.next==null) {
			return 1;
		}
		return 1 + sizeRecursive(temp.next);
	}
	
	public void swapNodes (int data1, int data2) {
		Node prevOfFirst = head;
		Node prevOfSecond = head;
		Node temp = head;
		boolean find1 = false;
		boolean find2 = false;
		while (temp.next != null) {
			if (find1 && find2) {
				break;
			}
			if (temp.next.data == data1) {
				prevOfFirst = temp;
				find1 = true;
			}
			else if (temp.next.data == data2){
				prevOfSecond = temp;
				find2 = true;
			}
			temp = temp.next;
		}
		if (find1 && find2) {
			Node tempNext = prevOfFirst.next;
			prevOfFirst.next = prevOfSecond.next;
			prevOfSecond.next = tempNext;
			Node tempPrevNext = prevOfFirst.next.next;
			prevOfFirst.next.next = prevOfSecond.next.next;
			prevOfSecond.next.next = tempPrevNext;
		}
	}
	
	public void reverseLinkedList () {
		Node tail = head;
		Node currentNode = head.next;
		Node nextNode = head.next.next;
		Node prevNode = null;
		while (nextNode.next != null) {
			currentNode.next = prevNode;
			prevNode = currentNode;
			currentNode = nextNode;
			nextNode = nextNode.next;
		}
		currentNode.next = prevNode;
		nextNode.next = currentNode;
		head.next = nextNode;
	}
	
	public LinkedList mergeTwoSortedList (LinkedList l1, LinkedList l2) {
		Node temp1 = l1.head.next;
		Node temp2 = l2.head.next;
		LinkedList sortedList = new LinkedList();
		while (temp1 != null && temp2 != null) {
			if (temp1.data < temp2.data) {
				sortedList.insertAtEnd(temp1.data);
				temp1 = temp1.next;
			}else {
				sortedList.insertAtEnd(temp2.data);
				temp2 = temp2.next;
			}
		}
		if (temp2 == null) {
			while (temp1 != null) {
				sortedList.insertAtEnd(temp1.data);
				temp1 = temp1.next;
			}
		}
		if (temp1 == null) {
			while (temp2 != null) {
				sortedList.insertAtEnd(temp2.data);
				temp2 = temp2.next;
			}
		}
		return sortedList;
	}
	
	public LinkedList mergeTwoSortedListUsingRecursion (LinkedList l1, LinkedList l2) {
		Node temp1 = l1.head.next;
		Node temp2 = l2.head.next;
		LinkedList sortedList = new LinkedList();
		while (temp1 != null && temp2 != null) {
			if (temp1.data < temp2.data) {
				sortedList.insertAtEnd(temp1.data);
				temp1 = temp1.next;
			}else {
				sortedList.insertAtEnd(temp2.data);
				temp2 = temp2.next;
			}
		}
		if (temp2 == null) {
			while (temp1 != null) {
				sortedList.insertAtEnd(temp1.data);
				temp1 = temp1.next;
			}
		}
		if (temp1 == null) {
			while (temp2 != null) {
				sortedList.insertAtEnd(temp2.data);
				temp2 = temp2.next;
			}
		}
		return sortedList;
	}

	public void dispaly(){
		Node temp = head.next;
		while (temp != null){
			System.out.print(temp.data + "  ");
			temp = temp.next;
		}
	}
}
