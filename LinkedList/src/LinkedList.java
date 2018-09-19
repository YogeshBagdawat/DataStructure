
public class LinkedList {
	Node head;
	static int count=0;
	static 	class Node{
		int data;
		Node next;
		Node(int data){
			this.data=data;
			this.next=null;
		}
	}
	/*public static void main(String[]args){
		LinkedList list = new LinkedList();
		list.head= new Node(3);
		Node sec= new Node(8);
		Node third = new Node(4);
		list.head.next=sec;
		sec.next=third;
		list.insert(6);
		list.insert(11);
		list.insert(18);
		list.display();

	}*/
	//add element in first of list
	
	public void push1(int data){
		Node first = new  Node(data);
		//head=first;	

		first.next=head;
		head=first; 
		count++;
	}
	public void push2(int data){
		Node first = new  Node(data);
		//head=first;	

		first.next=head;
		head=first; 
		count++;
	}
	
	public void push(int data){
		Node first = new  Node(data);
		//head=first;	

		first.next=head;
		head=first; 
		count++;
	}
	//add element at last of list
	public void append(int data){
		Node last= new Node(data);
		Node temp=head;
		while(temp.next!=null){
			temp=temp.next;
		}
		temp.next=last;
		count++;
	}
	//insert element after  number of node
	public void insertAfterCount(int count,int data){
		int lcount =1;
		Node temp=head;
		Node after = new Node(data);
		while(lcount<count){
			temp=temp.next;
			lcount++;
		}
		after.next=temp.next;
		temp.next=after;
		this.count++;
	}
	//delete a node from list
	public void deleteNode(int data){
		Node temp=head,prev=null;
		if(temp!=null&&temp.data==data){
			head=temp.next;
		}
		else{
			while(temp!=null&&temp.data!=data){
				prev=temp;
				temp=temp.next;
			}
			if(temp.data==data){
				prev.next=temp.next;

			}

		}
	}
	//swap two node of linked list
	public void swap(int key1,int key2){
		Node prev1=null,prev2=null;
		Node temp1 = head;
		Node temp2=head;


		while(temp1!=null&&key1!=temp1.data){
			prev1=temp1;
			//prev2=temp;
			temp1=temp1.next;
		}

		while(temp2!=null&&key2!=temp2.data){
			//prev1=temp;
			prev2=temp2;
			temp2=temp2.next;
		}
		if(temp1==null||temp2==null)
			return;
		if(prev1!=null)
			prev1.next=temp2;
		else
			head=temp2;
		if(prev2!=null) 
			prev2.next=temp1;
		else
			head=temp1;

		/*prev1.next=temp2;
		prev2.next=temp1;*/
		Node tem = temp1.next;
		temp1.next = temp2.next;
		temp2.next=tem;

	}
//reverse a linked list iterative
	public void reverseList(){


		Node current = head;
		Node previous=null;
		Node next=null;
		while(current!=null){
			next = current.next;
			current.next=previous;
			previous=current;
			current=next;
		}
		head=previous;
	}
	//reverse a linked list recursively
	public void recurseReverse(){
		head=reverseLinkedListRecursively(head);
	}
	public Node reverseLinkedListRecursively(Node temp){
		
		if(temp==null||temp.next==null)
			return temp;
					;
		Node remaining=reverseLinkedListRecursively(temp.next);
	     temp.next.next=temp;
	     temp.next=null;
	    return remaining; 
	}
	//merg sort for linkedlist
	public Node mergsort(Node originalhead){
	     
	      if(originalhead==null||originalhead.next==null)
	    	  return originalhead;
	      Node a=originalhead;
	      Node b=originalhead.next; 
	     while(b!=null&&b.next!=null){
	    		  originalhead=originalhead.next;
	    		  b=(b.next).next;
	    	  }
	         b=originalhead.next;
	        originalhead.next=null;
	    	 return mergList(mergsort(a),mergsort(b)); 
	      
    	}
	//merge two sorted list
	public Node mergList(Node list1,Node list2){
		LinkedList l1= new LinkedList();
		Node temp3=l1.head;
		
		Node temp1 = list1;
		Node temp2 = list2;
		while(temp2!=null||temp1!=null){
			if(temp1==null){
				l1.append(temp2.data);
				temp2=temp2.next;
				
			}
			else if(temp2==null){
				l1.append(temp1.data);
				temp1=temp1.next;
				
			}
			else
			{
				if(temp1.data<=temp2.data)
				{
					l1.append(temp1.data);
					temp1=temp1.next;

				}
				else{
					l1.append(temp2.data);
					temp2=temp2.next;
					
				}
					
			}
		}
		
		return l1.head;
		
	}
	
	//rotate a linkedlist counter clockwise
	public void rotateListByKNode(int number){
		int counter=0;
		Node temp=head;
		Node prev=head;
		while(counter<number&&temp!=null){
			temp=temp.next;
			counter++;
		}
		if(temp==null)
			return ;
		
		Node temp1=temp;
		
	    while(temp.next!=null){
	    	temp=temp.next;
	    }
	    temp.next=head;
	    head=temp1.next;
	    temp1.next=null;
	}
	
	//display linked list
	public void display(){
		Node temp=head;
		while(temp!=null){

			System.out.print(temp.data+" ");
			temp=temp.next;
		}
	}
	//number of node in linked list
	public int listLength(){
		return this.count;
	}
}
