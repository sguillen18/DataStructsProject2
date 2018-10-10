
public class Lisp {
	
	private LinkedStack <Integer> stack;
	
	public Lisp() {
		stack = new LinkedStack <Integer> ();
	}
	
	public int addition() {
		if(stack.isEmpty()) {
			return 0;
		}
		else {
			int sum = 0;
			LinkedStack<Integer> stack2 = new LinkedStack <Integer> ();
			while(!stack.isEmpty()) {
				int num = stack.pop();
				stack2.push(num);
			}
		}
		return 0;
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
