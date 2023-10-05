package clases;

public class ArrayQueue<T> {

	private T[] data;
	private int first;
	private int rear;
	
	
	public ArrayQueue(int capacity) {
		
		data = (T[]) new Object[capacity];
		//data = (T[]) Array.newInstance(arrayPasado, capacity)
		first=-1;
		rear=-1;
	}
	
	public int size() {
		
		int temp;
		temp = data.length-first+rear;
		temp = temp%data.length +1;
		return temp;
	}
	
	public boolean isEmpty() {
		return size()==0;
	}
	
	public void enqueue (T e) {
		if (size()<data.length){
			
			rear = (rear+1)%data.length;
			data[rear] = e;	
		}		
	}
	
	public T dequeue() {
		if (isEmpty()){
			return null;
		}
		T temp = data[first];
		data[first]=null;
		first= (first+1) % data.length;
		return temp;
	}
	
	
}