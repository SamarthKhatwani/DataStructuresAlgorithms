package linkedlists;

public class LinkedListDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LinkedList list = new LinkedList();
		for(int i=5;i>0;i--) {
			list.insertAtHead(i*2);
		}
		
		System.out.println(list.toString());
		list.insertSorted(9);
		System.out.println(list.toString());
		list.insertSorted(1);
		System.out.println(list.toString());
		list.insertSorted(11);
		System.out.println(list.toString());
		/*System.out.println(list.length());
		list.deleteFromHead();
		System.out.println(list.toString());
		System.out.println(list.length());
		System.out.println(list.find(4));	*/
		list.iterativeReverse();	
		System.out.println("first reverse -");
		System.out.println(list);
		
		list.recursiveReverse();
		System.out.println("second reverse -");
		System.out.println(list);
		
		list.recursiveReverse();
		System.out.println("reverse third -");
		System.out.println(list);
		
		list.iterativeReverse();	
		System.out.println("reverse fourth -");
		System.out.println(list);
	}

}
