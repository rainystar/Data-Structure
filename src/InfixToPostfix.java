import java.util.HashMap;
import java.util.Map;


public class InfixToPostfix {
	
	public static Map<Character, Integer> notationMap = new HashMap<Character, Integer>(){{
		put('+', 1);
		put('-', 1);
		put('*', 2);
		put('/', 2);
		put('(', 0);
		put(')', 0);
	}};
	
	public static String infixToPostfix(String inputStr) {
		char[] input = inputStr.toCharArray();
		StringBuilder outputSb = new StringBuilder();
		Node top = null;
		for (int i = 0; i < input.length; i++) {
			if (!notationMap.containsKey(input[i])) {	// output operand directly
				outputSb.append(input[i]);
			}
			else if (input[i] == '(') {
				Node node = new Node(input[i]);
				node.next = top;
				top = node;
			}
			else if (input[i] == ')') {
				while (top != null && top.c != '(') {	// assume the expression is valid
					outputSb.append(top.c);
					top = top.next;
				}
				top = top.next;
			}
			else {
				while (top != null && notationMap.get(top.c) >= notationMap.get(input[i])) {
					outputSb.append(top.c);
					top = top.next;
				}
				Node node = new Node(input[i]);
				node.next = top;
				top = node; 
			}
		}
		while (top != null) {
			outputSb.append(top.c);
			top = top.next;
		}
		return outputSb.toString();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(infixToPostfix("a+b*c+(d*(e+f))*g"));
	}

}
