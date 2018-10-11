import java.util.Stack;

public class LispInput {
	
	private Lisp l;
	private String input;
	private int spot;
	private int spotStop;
	private char[] charArray;
	
	public LispInput(String i) {
		charArray = i.toCharArray();
		input = i;
		l = new Lisp();
		spotStop = 0;
	}
	
	public LispInput() {
		this("");
	}
	public boolean checkBalance (String expression) {
        Stack <Character> openDelimiterStack = new Stack<>();
        boolean isBalanced = true;
        int index = 0;
        int characterCount = expression.length();
        char nextCharacter;
        
        while (isBalanced && index < characterCount){
            nextCharacter = expression.charAt(index);
            switch (nextCharacter)
            {
                case '(': case '[': case '{':
                    openDelimiterStack.push(nextCharacter);
                    break;
                case ')': case ']': case '}':
                    if (openDelimiterStack.isEmpty())
                        isBalanced = false;
                    else {
                        char openDelimiter = openDelimiterStack.pop();
                        isBalanced = isPaired (openDelimiter, nextCharacter );
                    }
                    break;
                default: //irelevant character
                    break;
                 
            }
            index ++;
        }
        if (!openDelimiterStack.empty())
            isBalanced = false;
        
        return isBalanced;
    }
	
    private static boolean isPaired (char first, char second) {
        return (first == '(' && second == ')' ||
                first == '[' && second == ']' ||
                first == '{' && second == '}');
    }
	
	public double analyze(char[] c, int i) {
		charArray = c;
		spot = i;
		double ans = 0;
		while(checkBalance(input) && spot < charArray.length) {
			switch(charArray[spot]) {
			case ' ':
				break;
			case '+':
				spot++;
				while (!(charArray[spot] == ')')){
					if(charArray[spot] == ' ') {
						spot++;
					}
					else if (charArray[spot] == '(') {
						spot++;
						LispInput newLisp = new LispInput(input);
						double subAns = newLisp.analyze(charArray, spot);
						spot = newLisp.getSpotStop();
						(l.getAddStack()).push(subAns);
						break;
					} 
					else {
						double num = (double) (charArray[spot] - '0');
						(l.getAddStack()).push(num);
						spot++;
					}
				}
				spot++;
				spotStop = spot;
				ans = l.addition();
				break;
			case '-':
				spot++;
				while (!(charArray[spot] == ')')){
					if(charArray[spot] == ' ') {
						spot++;
					}
					else if (charArray[spot] == '(') {
						spot++;
						LispInput newLisp = new LispInput(input);
						double subAns = newLisp.analyze(charArray, spot);
						spot = newLisp.getSpotStop();
						(l.getSubStack()).push(subAns);
					} else {
						double num = (double) (charArray[spot] - '0');
						(l.getSubStack()).push(num);
						spot++;
					}
				}
				spot++;
				spotStop = spot;
				ans = l.subtraction();
				break;
				
			case '*':
				spot++;
				while (!(charArray[spot] == ')')){
					if(charArray[spot] == ' ') {
						spot++;
					}
					else if (charArray[spot] == '(') {
						spot++;
						LispInput newLisp = new LispInput(input);
						double subAns = newLisp.analyze(charArray, spot);
						spot = newLisp.getSpotStop();
						(l.getMultStack()).push(subAns);
					} else {
						double num = (double) (charArray[spot] - '0');
						(l.getMultStack()).push(num);
						spot++;
					}
				}
				spot++;
				spotStop = spot;
				ans = l.multiplication();
				break;
			case '/':
				spot++;
				while (!(charArray[spot] == ')')){
					if(charArray[spot] == ' ') {
						spot++;
					}
					else if (charArray[spot] == '(') {
						spot++;
						LispInput newLisp = new LispInput(input);
						double subAns = newLisp.analyze(charArray, spot);
						spot = newLisp.getSpotStop();
						(l.getDivStack()).push(subAns);
					} else {
						double num = (double) (charArray[spot] - '0');
						(l.getDivStack()).push(num);
						spot++;
					}
				}
				spot++;
				spotStop = spot;
				ans = l.division();
				break;
			default:
				spot++;
				break;
			}
		}
			
		
		//will call on itself when finding another open parenthesis
		return ans;
	}
	
	public int convertDouble() {
		return (int) analyze(charArray, 0);
	}
	
	public int getSpotStop() {
		return spotStop;
	}

}
