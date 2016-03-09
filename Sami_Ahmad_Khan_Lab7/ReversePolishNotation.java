package Lab7;
import java.util.HashMap;
import java.util.Map;

public class ReversePolishNotation {
	
	private static Map<String, Integer> ops = new HashMap<String, Integer>(){
		{
	        put("+", 1);
	        put("-", 2);
	        put("*", 3);
	        put("/", 4);
        }
	};
	
	public Boolean checkPrecedence(String token, String temp){
		return ops.get(temp) >= ops.get(token);
	}
	
	public String toPostfix(String inFix){
		String[] infixArray;
		StringBuilder postFix = new StringBuilder();
		infixArray = inFix.split("\\s");
		
		CS401StackLinkedListImpl<String> stack  = new CS401StackLinkedListImpl<String>();
		
		for(String token: infixArray){
			if(ops.containsKey(token)){
				if(stack.size() == 0){
					stack.push(token);
				}
				else{
					while(stack.size() > 0 && checkPrecedence(token, stack.top())){
						postFix.append(stack.pop()).append(' ');
					}
					stack.push(token);
				}
			}
			else{
				postFix.append(token).append(' ');
			}
		}
		
			while(stack.size() > 0){
				postFix.append(stack.pop()).append(' ');
			}
		
		return postFix.toString();
	}
	
	public int evalPostFix(String postFix){
		String[] postFixArray;
		int x, y, z = 0;
		postFixArray = postFix.split("\\s");
		
		CS401StackLinkedListImpl<Integer> stack_int = new CS401StackLinkedListImpl<Integer>(); 
		
		for(String token: postFixArray){
			char ch = token.charAt(0);
			
			if(Character.isDigit(ch)){
				stack_int.push(Integer.parseInt(token));
			}
			else{
				x = stack_int.pop();
				y = stack_int.pop();
				
				switch (ch) {
				case '+':
					z = x + y;
					break;
				case '-':
					z = y - x;
					break;
				case '*':
					z = x * y;
					break;
				case '/':
					z = y / x;
					break;
				default:
					break;
				}
				
				stack_int.push(z);
			}
		}
		
		return stack_int.pop();
	}

}
