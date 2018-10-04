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
			n = next;
		}
	}
	
	public LinkedStack() {
		topNode = null;
	}
	
	public void push(T item) {
		check initalization();
		Node newNode = new Node(item);
		newNode.setNext(topNode);
		topNode = newNode;
	}
	
	public boolean isEmpty() {
		return(topNode == null);
	}
	
	public void clear() {
		topNode = null;
	}
	
	public T pop() {
		if(isEmpty()) {
			throw new EmptyStackException();
		}
		T outData = topNode.getData();
		topNode = topNode.getNext();
		return outData;
	}
	
	private void checkInitialization() {
		if(!initialized) {
			throw new EmptyStackException();
		}
	}

	@Override
	public T peek() {
		// TODO Auto-generated method stub
		return null;
	}
	
}
