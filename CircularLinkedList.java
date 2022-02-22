package List;

import java.util.NoSuchElementException;

public class CircularLinkedList {

	private Listnode last;
	private int length;
	
	private class Listnode{
		private Listnode next;
		private int data;
		
		public Listnode(int data) {
			this.data = data;
		}
		
	}
	
	public CircularLinkedList() {
		last = null;
		length = 0;
	}
	
	public int length() {
		return length;
	}
	
	public boolean isEmpty() {
		return length == 0;
	}
	
	public void createCircularLinkedList() {
		Listnode first = new Listnode(10);
		Listnode second = new Listnode(20);
		Listnode third = new Listnode(30);
		Listnode forth = new Listnode(40);
		Listnode fifth = new Listnode(50);
		
		first.next = second;
		second.next = third;
		third.next = forth;
		forth.next = fifth;
		fifth.next = first;
		
		last = fifth;
	}
	
	public void display() {
		if(last == null) {
			return ;
		}
		Listnode first = last.next;
		while(first!=last) {
			System.out.print(first.data + " ");
			first = first.next;
		}
		System.out.print(first.data + " ");
	}
	
	public void insertStart(int data) {
		Listnode temp = new Listnode(data);
		if(last == null) {
			last = temp;
		}
		else {
			temp.next = last.next;
		}
		last.next = temp;
		length++;
	}
	
	public void insertEnd(int data) {
		Listnode temp = new Listnode(data);
		if(last == null) {
			last = temp;
			last.next = last;
		}
		else {
			temp.next = last.next;
			last.next = temp;
			last = temp;
		}
		length++;
	}
	
	public Listnode deleteFirstNode() {
		if (isEmpty()) {
			throw new NoSuchElementException();
		}
		Listnode temp = last.next;
		if(last.next == last) {
			last = null;
		}
		else {
			last.next = temp.next;
		}
		temp.next = null;
		length--;
		return temp;
	}
	public static void main(String[] args) {
		CircularLinkedList cll = new CircularLinkedList();
		//cll.createCircularLinkedList();
		
		/*cll.insertStart(50);
		cll.insertStart(40);
		cll.insertStart(30);
		cll.insertStart(20);
		cll.insertStart(10);*/
		cll.insertEnd(60);
		cll.insertEnd(70);
		cll.insertEnd(80);
		cll.insertEnd(90);
		cll.insertEnd(100);
		cll.display();
		System.out.println();
		cll.deleteFirstNode();
		cll.display();
		System.out.println();
		cll.deleteFirstNode();
		cll.display();
		System.out.println();
		cll.deleteFirstNode();
		cll.display();
		System.out.println();
		cll.deleteFirstNode();
		cll.display();
		System.out.println();
		cll.deleteFirstNode();
		cll.display();
		System.out.println();
		cll.deleteFirstNode();
		cll.display();
	}
	

}

