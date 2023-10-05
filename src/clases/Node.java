package clases;

public class Node <T>{

	private T data;
	private Node<T> next;
	
	public Node() {

	}
	public Node(T e) {
		data=e;
	}
	
	public T getData() {
		return data;
	}
	
	public Node<T> getNext() {
		return next;
	}
	
	public void setData(T e) {
		data=e;
	}
	
	public void setNext(Node<T> n) {
		next=n;
	}
	
}

