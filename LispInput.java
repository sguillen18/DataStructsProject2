
public class LispInput {
	
	private String input;
	private Lisp l;
	
	public LispInput(String i) {
		input = i;
		l = new Lisp();
	}
	
	public LispInput() {
		this("");
	}
	
	public double analyze() {
		//will call on itself when finding another open parenthesis
		return 0.0;
	}
	
	public int convertDouble() {
		return 0;
	}

}
