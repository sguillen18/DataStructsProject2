
public class Lisp {
	
	private LinkedStack <Double> stackAdd;
	private LinkedStack <Double> stackSub;
	private LinkedStack <Double> stackMult;
	private LinkedStack <Double> stackDiv;
	
	public Lisp() {
		stackAdd = new LinkedStack <Double> ();
		stackSub = new LinkedStack <Double> ();
		stackMult = new LinkedStack <Double> ();
		stackDiv = new LinkedStack <Double> ();
	}
	
	public LinkedStack <Double> getAddStack(){
		return stackAdd;
	}
	
	public LinkedStack <Double> getSubStack(){
		return stackSub;
	}
	
	public LinkedStack <Double> getMultStack(){
		return stackMult;
	}
	
	public LinkedStack <Double> getDivStack(){
		return stackDiv;
	}
	
	
	public LinkedStack <Double> copy(LinkedStack <Double> stack) {
		LinkedStack <Double> copyBackwards = new LinkedStack <Double>();
		LinkedStack <Double> copyForwards = new LinkedStack <Double>();
		while(!stack.isEmpty()) {
			double item = stack.pop();
			copyBackwards.push(item);
		}
		
		while(!stack.isEmpty()) {
			double item = copyBackwards.pop();
			copyForwards.push(item);
		}
		
		stack = copyForwards;
		
		return copyForwards;
		
	}
	
	public LinkedStack <Double> copyBackwards(LinkedStack <Double> stack) {
		LinkedStack <Double> copyBackwards = new LinkedStack <Double>();
		LinkedStack <Double> copyForwards = new LinkedStack <Double>();
		while(!stack.isEmpty()) {
			double item = stack.pop();
			copyBackwards.push(item);
		}
		
		while(!stack.isEmpty()) {
			double item = copyBackwards.pop();
			copyForwards.push(item);
		}
		
		stack = copyForwards;
		
		return copyBackwards;
		
	}
	
	public double addition() {
		if(stackAdd.isEmpty()) {
			return 0;
		}
		else {
			double sum = 0;
			LinkedStack<Double> stack2 = copy(stackAdd);
			while(!stack2.isEmpty()) {
				sum += stack2.pop();
			}
			return sum;
		}
	}

	public double subtraction() {
		double sub = 0;
		LinkedStack<Double> stack2 = copyBackwards(stackSub);
		if(stackSub.getSize() == 1) {
			return 0 - stack2.pop();
		}
		else if (stackSub.getSize() > 1) {
			sub = stack2.pop();
			while(!stack2.isEmpty()) {
				sub -= stack2.pop();
			}
			return sub;
		}
		return 0;
	}

	public double multiplication() {
		return 0;
	}

	public double division() {
		double div = 0;
		LinkedStack<Double> stack2 = copyBackwards(stackSub);
		return 0;
	}

}
