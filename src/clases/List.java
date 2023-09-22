package clases;

public class List {
	
	private Node head;
	private Node tail;
	private int size;
	
	public List() {
		head=null;
		tail=null;
		size=0;
	}
	
	public int size() {
		 return size;
	}
	
	public Boolean isEmpty() {
		if (size==0){
			return true;
		}
		return false;
	}
	public void setSize(int s){
		size=s;
	}
	public Node First() {
		return head;
	}
	public Node Last() {
		return tail;
	}
	public void addFirst(Object e) {
		
		Node n = new Node(e);
		if (isEmpty()) {
			head = n;
			tail = n;
		}
		else {
			
			n.setNext(head);
			head = n;
			
		}
		size++;
		
	}
	public void addLast(Object e) {
		
		Node n = new Node(e);
		if(isEmpty()) {
			head = n;
			tail = n;
		}
		else {
			tail.setNext(n);
			tail = n;
		}
		size++;	
	}
	public Object removeFirst() {
		if (!(isEmpty())) {
			
			
			Node temp = head;
			head = temp.getNext();
			temp.setNext(null);
			size--;
			return temp.getData();
			
		}
		return null;
	}
	
	public Object removeLast() {
		if (size==1) {
			return removeFirst();
		}
		else {
			Node temp = tail;
			Node anterior =head;
			while(anterior.getNext()!=tail) {
				
				anterior = anterior.getNext();
				
			}
			anterior.setNext(null);
			tail = anterior;
			size--;
			return temp.getData();
			
		}
		
	}
	

}
