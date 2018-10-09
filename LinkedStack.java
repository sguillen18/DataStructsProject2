import java.util.*;

public  class LinkedStack <T> implements StackInterface <T>{
	
	private Node topNode;
	private Node lastNode;
	
	private class Node{
		T data;
		Node next;
		
		public Node (T data) {
			this.data = data;
			next = null;
		}
		
		public Node (T data, Node n) {
			this.data = data;
			this.next = n;
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
	}
	
	@Override
	public void push(T item) {
		Node newNode = new Node(item);
		if (isEmpty()) {
			lastNode = newNode;
		}
		newNode.setNext(topNode);
		topNode = newNode;
	}
	
	public boolean isEmpty() {
		return(topNode == null);
	}
	
	public void clear() {
		topNode = null;
	}
	
	@Override
	//NEED TO SET THE NEXT NODE AS TOPNODE
	public T pop() {
		if(isEmpty()) {
			throw new EmptyStackException();
		}
		T outData = topNode.getData();
		topNode = topNode.getNext();
		return outData;
	}
	
	private void checkInitialization() {
		//is this how we check initialization? based on LinkedStack's constructor
		if(topNode == null) {
			throw new EmptyStackException();
		}
	}


	@Override
	public T peek() {
		//checkInitialization();
		T outData = topNode.getData();
		return outData;
	}
	
}