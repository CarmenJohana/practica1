package clases;

public class DoubleList<T>{

	
	private DoubleNode<T> head;
	private DoubleNode <T>tail;
	private int size;
	public DoubleList() {
		size=0;
		head=null;
		tail=null;
	}
	
	
	public int size() {
		return size;
	}
	
	public Boolean isEmpty(){
		return size==0;
	}
	
	public DoubleNode<T> first(){
		return head;
	}
	public DoubleNode<T> last() {
		return tail;
	}
	public void addFirst(T e) {
		DoubleNode<T> n = new DoubleNode<T>(e);
		if (isEmpty()) {
			head = n;
			tail = n;
		}
		else {
			
			n.setNext(head);
			head.setPrev(n);
			head = n;
			
			
		}
		size++;
	}
	public void addLast(T e) {
		DoubleNode<T> n = new DoubleNode<T>(e);
		if (isEmpty()) {
			head = n;
			tail = n;
		}
		else {
			tail.setNext(n);
			n.setPrev(tail);
			tail=n;
			
		}
		size++;
	}
	
	public T removeFirst() {
		if (isEmpty()) {
			return null;
		}
		DoubleNode<T> temp = head;
		head = temp.getNext();
		temp.setNext(null);
		if(head!=null) {
			head.setPrev(null);
		}
		size--;
		return temp.getData();
	}
	
	public T removeLast() {
		if (isEmpty()) {
			return null;
		}
		DoubleNode<T> temp = tail;
		tail = temp.getPrev();
		if(tail!=null) {
			tail.setNext(null);
		}
		temp.setPrev(null);
		size--;
		return temp.getData();
	}
	
	public T remove(DoubleNode<T> n) {
		size--;
		if(n.equals(head)) {
		return removeFirst();
		}
		else if(n.equals(tail)){
			
			return removeLast();
		}
		else {
			
			T e = n.getData();
			DoubleNode<T> temp_prev = n.getPrev();
			DoubleNode<T> temp_next = n.getNext();
			temp_prev.setNext(temp_next);
			temp_next.setPrev(temp_prev);
			n.setNext(null);
			n.setPrev(null);
			
			return e;
		}
		
	}
	public void addBefore(DoubleNode<T> n, T e) {
		if(n.equals(head)) {
			addFirst(e);
		}
		else {
			DoubleNode<T> m = new DoubleNode<T>(e);
			DoubleNode<T> temp_prev = n.getPrev();
			temp_prev.setNext(m);
			m.setPrev(temp_prev);
			m.setNext(n);
			n.setPrev(m);	
			size++;
		}
		
		
	}
	public void addAfter(DoubleNode<T> n, T e) {
		if (n.equals(tail)) {
			addLast(e);
		}
		else {
			DoubleNode<T> m = new DoubleNode<T>(e);
			DoubleNode<T> temp_next = n.getNext();
			n.setNext(m);
			m.setPrev(n);
			m.setNext(temp_next);
			temp_next.setPrev(m);
			size++;
		}
		
	}
	
	
	public DoubleNode<T> Middle(DoubleNode<T> start, DoubleNode<T> end) {
		
		
		if (start.equals(null)|| end.equals(null)) {
			return null;
		}
		else if (start.equals(end)) {
			
			return start;
			
		}
		else {
			
			DoubleNode<T> temp1=first();
			DoubleNode<T> temp2=first();
			while(temp2!=end) {
				temp2=temp2.getNext();
				if(temp2!=end) {
					temp2=temp2.getNext();
					temp1=temp1.getNext();
					
				}
			}
			return temp1;
			
		}
		
	}
}

