package clases;

public class Node {

	private Object data;
	private Node next;
	
	public Node() {

	}
	public Node(Object e) {
		data=e;
	}
	
	public Object getData() {
		return data;
	}
	
	public Node getNext() {
		return next;
	}
	
	public void setData(Object e) {
		data=e;
	}
	
	public void setNext(Node n) {
		next=n;
	}
	
	
	
	
	
}
