
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
	
	public LinkedStack <Double> copyBackwards(LinkedStack <Double> stack) {
		LinkedStack <Double> copyBackwards = new LinkedStack <Double>();
		while(!stack.isEmpty()) {
			double item = stack.pop();
			copyBackwards.push(item);
		}
		
		return copyBackwards;
		
	}
	
	public double addition() {
		if(stackAdd.isEmpty()) {
			return 0;
		}
		else {
			double sum = 0;
			while(!stackAdd.isEmpty()) {
				sum += stackAdd.pop();
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
			stackSub.clear();
			return sub;
		}
		return 0;
	}

	public double multiplication() {
		if(stackMult.isEmpty()) {
			return 1;
		}
		else {
			double product = 0;
			while(!stackMult.isEmpty()) {
				product *= stackMult.pop();
			}
			return product;
		}
	}

	public double division() {
		double div = 0;
		LinkedStack<Double> stack2 = copyBackwards(stackSub);
		if(stackSub.getSize() == 1) {
			return 1;
		}
		else if (stackSub.getSize() > 1) {
			div = stack2.pop();
			while(!stack2.isEmpty()) {
				div /= stack2.pop();
			}
			stackDiv.clear();
			return div;
		}
		return 0;
	}

}
