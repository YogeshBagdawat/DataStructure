
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
	
	}

}
