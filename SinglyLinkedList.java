package List;

public class SinglyLinkedList {
	//implementation of Linked List
	private Listnode head;
	
	private static class Listnode{
		private int data;
		private Listnode next;
		
		
		public Listnode(int data) {
		// TODO Auto-generated constructor stub
			this.data=data;
			this.next=null;
	}
	} 
	//display the node
	public void display() {
		Listnode current = head;
		while(current!=null) {
			System.out.print(current.data + "-->");
			current=current.next;
		}
		System.out.println("null");
	}
	//finding length of linked list
	
	public int length() {
		if(head==null) {
			return 0;
		}
		int count =0;
		Listnode current = head;
	while(current!=null) {
		count++;
	    current=current.next;
	}
	return count;
}
		//inserting a node at the starting of the list
		public void insertfirst(int value) {
			Listnode newnode = new Listnode(value);
			newnode.next = head;
			head = newnode;
		}
		public void insert(int pos, int value) {
			Listnode node= new Listnode(value);
			if(pos==1) {
				node.next=head;
				head=node;
			}
			else {
				Listnode previous = head;
				int count=1;
				while(count<pos-1) {
					previous=previous.next;
					count++;
				}
				Listnode current = previous.next;
				node.next = current;
				previous.next=node;
			}
		}
		public void insertlast(int value) {
			Listnode newnode = new Listnode(value);
			if(head == null) {
				head = newnode;
				return;
			}
			Listnode current = head;
			while(null!=current.next) {
				current = current.next;
			}
			current.next = newnode;
		}
		public Listnode deletefirst() {
			if(head==null) {
				return null;
			}
			Listnode temp = head;
			head = head.next;
			temp.next = null;
			return temp;
			
		}
		public Listnode deletelast() {
			if(head==null || head.next==null) {
				return head;
			}
			else {
				Listnode current = head;
				Listnode previous = null;
				while(current.next!=null) {
					previous=current;
					current=current.next;
				}
				previous.next=null;
				return current;
			}
		}
		
		public void delete(int pos) {
			if(pos==1) {
				head=head.next;
			}
			else {
				Listnode previous = head;
				int count = 1;
				while(count<pos-1) {
					previous = previous.next;
					count++;
				}
				Listnode current = previous.next;
				previous.next = current.next;
			}
		}
		public boolean find(int searchKey) {
			if(head == null) {
				return false;
			}

			Listnode current = head;
			while(current != null) {
				if(current.data == searchKey) {
					return true;
				}
				current = current.next;
			}
			return false;
		}
		
		//find middle node in a singly linked list
		
		public Listnode getMiddle() {
			if(head == null) {
				return null;
			}
			else {
				Listnode slowptr = head;
				Listnode fastptr = head;
				while(fastptr != null && fastptr.next != null) {
					slowptr = slowptr.next;
					fastptr = fastptr.next.next;
				}
				return slowptr;
			}
		}
		public Listnode getNNodeFromEnd(int n) {
			if(head == null){
				return null;
			}
			if(n<0) {
				throw new IllegalArgumentException("Invalid value: n = "+n);
			}
			
			Listnode mainptr = head;
			Listnode refptr = head;
			int count = 0;
			while(count<n) {
				if(refptr == null) {
					throw new IllegalArgumentException(n+" is greater than the number of node of the List");
				}
				refptr = refptr.next;
				count ++ ;
			}
			while(refptr!=null) {
				refptr = refptr.next;
				mainptr = mainptr.next;
			}
			return mainptr;

			
		}
		
		public void removeDuplicate() {
			if(head == null) {
				return;
			}
			
			Listnode current = head;
			while(current!=null && current.next != null) {
				if(current.data == current.next.data) {
					current.next = current.next.next;
				}
				else {
					current = current.next;
				}
			}
		}
		
		public Listnode insertInSorted(int value) {
			
			Listnode newnode = new Listnode(value);
			
			if(head == null) {
				return newnode;
			}
			
			Listnode current = head;
			Listnode temp = null;
			while(current != null && current.data < newnode.data) {
				temp = current;
				current = current.next;
			}
			
			newnode.next = current;
			temp.next = newnode;
			return head;
		}
		public void deletenode(int key) {
			Listnode current = head;
			Listnode temp = null;
			if(current != null && current.data == key) {
				head = current.next;
			}
			while(current!=null && current.data != key) {
				temp = current;
				current = current.next;
			}
			if(current == null) {
				return;
			}
			temp.next = current.next;
		}
		
		public boolean containsloop() {
			Listnode fastptr = head;
			Listnode slowptr = head;
			
			while(fastptr!=null && fastptr.next!=null) {
				fastptr = fastptr.next.next;
				slowptr = slowptr.next;
				if(slowptr == fastptr) {
					return true;
				}
			}
			return false;

		}
		public Listnode startingNodeInALoop() {
			Listnode fastptr = head;
			Listnode slowptr = head;
			
			while(fastptr!=null && fastptr.next!=null) {
				fastptr = fastptr.next.next;
				slowptr = slowptr.next;
				if(slowptr == fastptr) {
					return getStartingNode(slowptr);
				}
			}
			return null;

		}
		public Listnode getStartingNode(Listnode slowptr) {
			Listnode temp = head;
			while(slowptr != temp) {
				temp = temp.next;
				slowptr = slowptr.next;
			}
			return slowptr;
		}
		public void createLoopInLinkedList() {
			Listnode first = new Listnode(10);
			Listnode second = new Listnode(20);
			Listnode third = new Listnode(30);
			Listnode forth = new Listnode(40);
			Listnode fifth = new Listnode(50);
			Listnode sixth = new Listnode(60);
			head= first;
			first.next = second;
			second.next = third;
			third.next = forth;
			forth.next = fifth;
			fifth.next = sixth;
			sixth.next = third;
		}
		public void removeLoop() {
			Listnode fastptr = head;
			Listnode slowptr = head;
			
			while(fastptr!=null && fastptr.next!=null) {
				fastptr = fastptr.next.next;
				slowptr = slowptr.next;
				if(slowptr == fastptr) {
					removingTheLoop(slowptr);
					return ;
				}
			}

		}
		
		public void removingTheLoop(Listnode slowptr) {
			Listnode temp = head;
			while(slowptr.next != temp.next) {
				temp = temp.next;
				slowptr = slowptr.next;
			}
			slowptr.next = null;
			
		}
		
		
		
		public static Listnode merge(Listnode a,Listnode b) {
			Listnode dummy = new Listnode(0);
			Listnode tail = dummy;
			while(a!=null && b!=null) {
				if(a.data <= b.data) {
					tail.next = a;
					a = a.next;
				}
				else {
					tail.next = b;
					b = b.next;
				}
				tail = tail.next;
			}
			if(a == null) {
				tail.next = b;
			}
			else {
				tail.next = a;
			}
			return dummy.next;
		}
		public static Listnode addTwoSLL(Listnode a,Listnode b) {
			Listnode dummy = new Listnode(0);
			Listnode tail = dummy;
			int carry = 0;
			while(a!=null || b!=null) {
				int x = (a!=null) ? a.data : 0;
				int y = (b!=null) ? b.data : 0;
				int sum = carry + x + y;
				carry = sum/10;
				tail.next = new Listnode(sum%10);
				tail = tail.next;
				if(a!=null)    a = a.next;
				if(b!=null)    b = b.next;
					}
				if(carry > 0) {
					tail.next = new Listnode(carry);
				}
			return dummy.next;
		}
   //creating the nodes and connect then
		public static void main(String[] args) {
		// TODO Auto-generated method stub
		//SinglyLinkedList sll = new SinglyLinkedList();
		/*sll.head = new Listnode(10);
		Listnode second = new Listnode(20);
		Listnode third = new Listnode(30);
		Listnode forth = new Listnode(40);
		Listnode fifth = new Listnode(60);
		Listnode sixth = new Listnode(70);
		sll.head.next = second;
		second.next = third;
		third.next = forth;
		forth.next = fifth;
		fifth.next = sixth;*/
		SinglyLinkedList sll1 = new SinglyLinkedList();
		sll1.insertlast(1);
		sll1.insertlast(3);
		sll1.insertlast(5);
		sll1.insertlast(7);
		sll1.insertlast(9);

		
		SinglyLinkedList sll2 = new SinglyLinkedList();
		sll2.insertlast(2);
		sll2.insertlast(4);
		sll2.insertlast(6);
		sll2.insertlast(8);

		
		
		sll1.display();
		sll2.display();
		
		/*SinglyLinkedList result = new SinglyLinkedList();
		result.head = merge(sll1.head, sll2.head);
		result.display();*/
		
		SinglyLinkedList addition = new SinglyLinkedList();
		addition.head = addTwoSLL(sll1.head, sll2.head);
		addition.display();
		
		//sll.createLoopInLinkedList();
		//System.out.println(sll.containsloop());
		//System.out.println(sll.startingNodeInALoop().data);
		//sll.removeLoop();
		//sll.display();
		//sll.deletenode(70);
		//sll.display();

		//sll.insertInSorted(50);
		//sll.display();
		//sll.removeDuplicate();
		//sll.display();
		//sll.insertfirst(0);
		//sll.insertfirst(10);
		//sll.insertfirst(20);
		//sll.insertfirst(30);
		//sll.insertlast(60);
		//sll.insertlast(70);
		//sll.insertlast(80);
		
		//sll.insert(1, 11);
		//sll.insert(2, 22);
		//sll.insert(1, 33);
		//sll.insert(2, 44);
		//sll.display();
		//System.out.println("Length is :- " + sll.length());
		
		//System.out.println(sll.deletefirst().data);
		//sll.display();
		
		//System.out.println(sll.deletelast().data);
		
		//sll.delete(2);
		//sll.display();
		
		//if(sll.find(20)) {
		//	System.out.println("search key found");
		//}
		//else {
		//	System.out.println("serchkey not found");
		//}
		//Listnode middlenode = sll.getMiddle();
		//System.out.println(middlenode.data);
		
		//Listnode NNode = sll.getNNodeFromEnd(10);
		//System.out.println("Nth Node from the end of the List = "+ NNode.data);
		
	}

}
