import java.util.Scanner;

public class Test {


	public static void main(String[] args) {
		
		
		LinkedStack<String> p = new LinkedStack<String>();

		
		String test = "5";
		String test2 = "10";
		p.push(test);
		p.push(test2);
		System.out.println(p.peek());
		System.out.println(p.pop());
		System.out.println(p.peek());
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter a valid Lisp expression.");
		String input = sc.nextLine();
		
		LispInput lispTest = new LispInput(input);
		
		
		sc.close();
		

	}

}
