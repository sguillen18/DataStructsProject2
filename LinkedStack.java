import java.util.*;

public  class LinkedStack <T> implements StackInterface <T>{
	
	private Node topNode;
	private Node lastNode;
	private int size;
	
	private class Node{
		T data;
		Node next;
		
		public Node (T data) {
			this.data = data;
			next = null;
		}
		
		public T getData() {
			return data;
		}
		
		public void setData(T item) {
			data = item;
		}
		
		public Node getNext() {
			return next;
		}
		
		public void setNext(Node n) {
			next = n;
		}
	}
	
	public LinkedStack() {
		topNode = null;
		lastNode = null;
		size = 0;
	}
	
	public int getSize() {
		return size;
	}
	
	@Override
	public void push(T item) {
		Node newNode = new Node(item);
		if (isEmpty()) {
			lastNode = newNode;
		}
		newNode.setNext(topNode);
		topNode = newNode;
		size++;
	}
	
	public boolean isEmpty() {
		return(topNode == null);
	}
	
	public void clear() {
		topNode = null;
		size = 0;
	}
	
	@Override
	//NEED TO SET THE NEXT NODE AS TOPNODE
	public T pop() {
		if(isEmpty()) {
			throw new EmptyStackException();
		}
		T outData = topNode.getData();
		topNode = topNode.getNext();
		size--;
		return outData;
	}


	@Override
	public T peek() {
		//checkInitialization();
		T outData = topNode.getData();
		return outData;
	}
	
}