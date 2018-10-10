
public class Lisp {
	
	private LinkedStack <Integer> stack;
	
	public Lisp() {
		stack = new LinkedStack <Integer> ();
	}
	
	public LinkedStack <Integer> copy() {
		LinkedStack <Integer> copyBackwards = new LinkedStack <Integer>();
		LinkedStack <Integer> copyForwards = new LinkedStack <Integer>();
		while(!stack.isEmpty()) {
			int item = stack.pop();
			copyBackwards.push(item);
		}
		
		while(!stack.isEmpty()) {
			int item = copyBackwards.pop();
			copyForwards.push(item);
		}
		
		stack = copyForwards;
		
		return copyForwards;
		
	}
	
	public int addition() {
		if(stack.isEmpty()) {
			return 0;
		}
		else {
			int sum = 0;
			LinkedStack<Integer> stack2 = copy();
			while(!stack2.isEmpty()) {
				sum += stack2.pop();
			}
			return sum;
		}
	}

	public int subtraction() {
		return 0;
	}

	public int multiplication() {
		return 0;
	}

	public int division() {
		return 0;
	}

}
