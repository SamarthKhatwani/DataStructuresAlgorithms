package linkedlists;

public class LinkedList {
	
	private Node head;
	
	public void insertAtHead(int data) {
		Node newNode= new Node(data);
		newNode.setNext(this.head);
		this.head=newNode;
	}
	
	public int length() {
		int length=0;
		Node currentNode= this.head;
		while(currentNode!=null) {
			length++;
			currentNode=currentNode.getNext();
		}
		return length;
	}
	
	public void deleteFromHead() {
		Node head= this.head;
		this.head=head.getNext();
	}
	
	public Node find(int data) {
		Node n=this.head;
		while(n!=null) {
			if(n.getData()==data) {
				return n;
			}
			n=n.getNext();
		}
		return null;
	}
	
	public void insertSorted(int data) {
		Node newNode= new Node(data);
		Node current = this.head;
		
		if(data<head.getData()) {
			newNode.setNext(this.head);
			this.head=newNode;
			return;
		}
		Node next=this.head.getNext();
		while(next!=null ) {
			if(data>=current.getData() && data <next.getData()) {
				newNode.setNext(next);
				current.setNext(newNode);
				return;
			}
			current=next;
			next=next.getNext();
		}
		current.setNext(newNode);
		
	
	}
	
	public void iterativeReverse() {
		Node prev=this.head;
		if(prev==null) {
			return;
		}
		
		Node curr= prev.getNext();
		if(curr==null) {
			return;
		}
		Node next=curr.getNext();
		prev.setNext(null);
		if(next==null) {
			curr.setNext(prev);
			return;
		}
		Node temp;
		
		 while(next!=null) {
			 temp=next.getNext();
			 curr.setNext(prev);
			 next.setNext(curr);
			 
			 prev=curr;
			 curr=next;
			 next=temp;
			 
		 }
		 this.head=curr;
		 return;
		
		
	}
	
	public void recursiveReverse() {
		recursiveReverseHelper(null,this.head);
	}
	
	private void recursiveReverseHelper(Node curr,Node next) {
		if(next==null) {
			this.head=curr;
			return;
		}
		else {
			Node temp=next.getNext();
			next.setNext(curr);
			
			recursiveReverseHelper(next, temp);
		}
	}
	@Override		
	public String toString() {
		
		StringBuilder sb = new StringBuilder();
		Node current=this.head;
		sb.append("{ ");
		while(current!=null) {
			sb.append(current.toString()+" ");
			current=current.getNext();
		}
		sb.append(" }");
		return sb.toString();
	}
	
	

}
