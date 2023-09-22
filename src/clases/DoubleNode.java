package clases;

public class DoubleNode {
	
	private Object data;
	private DoubleNode next;
	private DoubleNode prev;
	
	public DoubleNode() {
		data=null;
		prev=null;
		next=null;
	}

	public DoubleNode(Object d) {
		this();
		data=d;
		
	}
	public void setData(Object d) {
		data=d;
	}
	public void setNext(DoubleNode n){
		next=n;
	}
	public void setPrev(DoubleNode p) {
		prev=p;
	}
	public Object getData() {
		return data;
	}
	public DoubleNode getNext() {
		return next;
	}
	public DoubleNode getPrev() {
		return prev;
	}
}
