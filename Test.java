
public class Test {

	public static void main(String[] args) {
		
		
		LinkedStack<String> p = new LinkedStack<String>();

		
		String test = "5";
		String test2 = "10";
		p.push(test);
		p.push(test2);
		System.out.println(p.peek());
		//it pops the 10? i think? but then doesn't make the 5 the topnode
		System.out.println(p.pop());
		System.out.println(p.peek());
		
		/*Expected output
		 * 10
		 * 10
		 * 5
		 */

	}

}
