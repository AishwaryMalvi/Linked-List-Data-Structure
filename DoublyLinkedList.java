package List;

import java.util.NoSuchElementException;

public class DoublyLinkedList {

	private Listnode head;
	private Listnode tail;
	private int length;
	
	private class Listnode{
		private int data;
		private Listnode previous;
		private Listnode next;
		
		public Listnode(int data) {
			this.data = data;
		}
	}
	public DoublyLinkedList() {
		this.head = null;
		this.tail = null;
		this.length = 0;
	}
	public boolean isEmpty() {
		return length == 0;
	}
	public int length() {
		return length;
	}
	public void insertEnd(int value) {
		Listnode newNode = new Listnode(value);
		if(isEmpty()) {
			head = newNode;
		} else {
			tail.next = newNode;
		}
		newNode.previous = tail;
		tail = newNode;
		length++;
	}
	
	public void insertFirst(int value) {
		Listnode newNode = new Listnode(value);
		if(isEmpty()) {
			tail = newNode;
		}
		else {
			head.previous = newNode;
		}
		newNode.next = head;
		head = newNode;
		length++;
	}
	public void displayForward() {
		if(head == null) {
		return;
	}
		Listnode temp = head;
		while(temp != null) {
			System.out.print(temp.data + "-->");
			temp = temp.next;
		}
		System.out.print("null");
	}
	
	public void displayBackword() {
		if(tail == null) {
			return;
		}
		Listnode temp = tail;
		while(temp != null) {
			System.out.print(temp.data + "-->");
			temp = temp.previous;
		}
		System.out.print("null");
	}
	
	public Listnode deleteFirstNode() {
		if(isEmpty()) {
			throw new NoSuchElementException();
		}
		Listnode temp = head;
		if(head == tail) {
			tail = null;
		}
		else {
			head.next.previous = null;
		}
		head = head.next;
		temp.next = null;
		length--;
		return temp;
	}
	
	public Listnode deleteLastNode() {
		if(isEmpty()) {
			throw new NoSuchElementException();
		}
		Listnode temp = tail;
		if(head == tail) {
			head = null;
		}
		else {
			tail.previous.next = null;
		}
		tail = tail.previous;
		temp.previous = null;
		length--;
		return temp;
	}
	
	public static void main(String[] args) {
		DoublyLinkedList dll = new DoublyLinkedList();
		dll.insertFirst(40);
		dll.insertFirst(30);
		dll.insertFirst(20);
		dll.insertFirst(10);
		
		dll.displayForward();
		System.out.println();
		/*dll.deleteLastNode();
		dll.deleteLastNode();
		dll.deleteLastNode();
		dll.deleteLastNode();
		dll.deleteLastNode();
		dll.deleteFirstNode();
		dll.deleteFirstNode();
		dll.deleteFirstNode();
		dll.deleteFirstNode();*/
		System.out.println();
	    dll.displayForward();
		
		
	
	}
}
