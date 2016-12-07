
public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
    LinkedList list = new LinkedList();
    
    list.push(8);
    list.push(6);
    list.append(9);
    list.append(11);
    list.push(13);
    list.append(5);
    list.insertAfterCount(3, 17);
   // list.deleteNode(11);
    list.swap(68,33);
    list.display();
   // System.out.println(list.listLength());
    System.out.println();
    //list.reverseList();
    list.recurseReverse();
    list.display();
    LinkedList list1 = new LinkedList();		
     list1.append(1);
    list1.append(4);
    list1.append(6);
    list1.append(11);
    list1.append(7);
    list1.append(9);
   // list1.display();
  //  list2.display();
  //list3=  list1.mergList(list1.head,list2.head);
    list1.head=list1.mergsort(list1.head);
    list1.display();
			
		
	
	}

}
